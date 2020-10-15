package com.leinuo.completableFutureDemo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Create by leinuo on 2020/8/28
 * qq:1321404703 https://github.com/leinuo2016
 */
public class Demo1 {

    /**
     * 创建一个完成的CompletableFuture
     */
    static void demo(){
        CompletableFuture cf = CompletableFuture.completedFuture("message");
        System.out.println(cf.isDone());
        System.out.println(cf.getNow(null));
    }

    /**
     * 运行一个简单的异步阶段
     */
    static void runAsyncExample() {
        CompletableFuture cf = CompletableFuture.runAsync(()->{
            //此处利用守护线程去执行任务
            System.out.println("isDaemon:"+Thread.currentThread().isDaemon());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(cf.isDone());
        try {
            //Thread.sleep(1000);//1
            Thread.sleep(3000);  //2
            /** 1
             * false
             * isDaemon:true
             * false
             * 2
             * false
             * isDaemon:true
             * true
             */
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cf.isDone());
    }

    /**
     * 在前一个阶段上应用函数
     */
    static void thenApply(){
        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApply(s->{
            System.out.println("isDaemon:"+Thread.currentThread().isDaemon());
            return s.toUpperCase();
        }).thenApply(s -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("isDaemon:"+Thread.currentThread().isDaemon());
            return s+"11";
        });
        System.out.println(cf.isDone());
        //函数的执行会被阻塞，这意味着getNow()只有打斜操作被完成后才返回。
        System.out.println(cf.getNow(null));
    }

    /**
     * 在前一个阶段上异步应用函数
     * 异步操作会有守护线程执行
     */
    static void thenApplyAsync(){
        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(s->{
            System.out.println("isDaemon:"+Thread.currentThread().isDaemon());
            return s.toUpperCase();
        });
        System.out.println(cf.isDone());
        System.out.println(cf.getNow(null));
        System.out.println(cf.join());
    }

    static ExecutorService executor = Executors.newFixedThreadPool(3, new ThreadFactory() {
        int count = 1;
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r,"custom-thread-"+count++);
        }
    });

    /**
     * 使用定制的Executor在前一个阶段上异步应用函数
     */
    static void thenApplyAsyncWithExecutor(){
        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(s->{
            System.out.println(Thread.currentThread().getName());
            System.out.println("isDaemon:"+Thread.currentThread().isDaemon());
            threadSleep(2000);
            return s.toUpperCase();
        },executor);

       /* CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(s->{
            System.out.println(Thread.currentThread().getName());
            System.out.println("isDaemon:"+Thread.currentThread().isDaemon());
            threadSleep(2000);
            return s.toUpperCase();
        });*/
        System.out.println(cf.isDone());
        System.out.println(cf.getNow(null));
        System.out.println(cf.join());
    }

    /**
     * 消费前一阶段的结果
     */
    static void thenAccept(){
        StringBuilder stringBuilder = new StringBuilder();
        //thenAccept同步执行
        CompletableFuture.completedFuture("thenAccept message").
                thenAccept(s ->{
                    System.out.println("isDaemon:"+Thread.currentThread().isDaemon());
                    threadSleep(2000);
                    stringBuilder.append(s);
                });
        System.out.println(stringBuilder.length()>0);
        System.out.println(stringBuilder.toString());
    }

    /**
     * 异步地消费迁移阶段的结果
     */
    static void thenAcceptAsync(){
        StringBuilder stringBuilder = new StringBuilder();
        //thenAccept同步执行
        CompletableFuture cf = CompletableFuture.completedFuture("thenAccept message").
                thenAcceptAsync(s -> {
                    System.out.println("isDaemon:" + Thread.currentThread().isDaemon());
                    threadSleep(2000);
                    stringBuilder.append(s);
                });
        System.out.println(stringBuilder.length()>0);
        System.out.println("阻塞前："+stringBuilder.toString());
        //阻塞直到任务执行完成
        System.out.println("阻塞前 isDone："+cf.isDone());
        cf.join();
        System.out.println("阻塞后 isDone："+cf.isDone());
        System.out.println("阻塞后："+stringBuilder.toString());
    }

    /**
     * 完成计算异常
     */
   static void completeExceptionally(){
     /*  CompletableFuture cf = CompletableFuture.completedFuture("thenAccept message").
               thenApplyAsync(String::toUpperCase,CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS));*/
       CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(String::toUpperCase);
       CompletableFuture exceptionHandler = cf.handle((s, th) -> { return (th != null) ? "message upon cancel" : ""; });
       cf.completeExceptionally(new RuntimeException("completed exceptionally"));
       System.out.println(cf.isCompletedExceptionally());
       try {
           cf.join();
       } catch(CompletionException ex) { // just for testing
           System.out.println(ex.getCause().getMessage());
       }
       System.out.println(exceptionHandler.join());
   }

    /**
     * 取消计算
     */
    static void cancel() {
        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApplyAsync(String::toUpperCase);
//                CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS));
        CompletableFuture cf2 = cf.exceptionally(throwable -> "canceled message");
        System.out.println( cf.cancel(true));
        System.out.println( cf.isCompletedExceptionally());
        System.out.println( cf2.join());
    }

    /**
     * 在两个完成的阶段其中之一上应用函数
     */
    static void applyToEither(){
        String origin = "Apply";
        CompletableFuture cf = CompletableFuture.completedFuture(origin).thenApplyAsync(s -> s.toUpperCase());
        CompletableFuture cf2 = cf.applyToEither(CompletableFuture.completedFuture(origin).thenApplyAsync(s -> s.toLowerCase()), s -> s + "applyToEither");
        System.out.println(cf2.join().toString().endsWith("applyToEither"));
        System.out.println(cf2.join());
    }


    /**
     * 在两个完成的阶段其中之一上调用消费函数
     */
    static void acceptToEither(){
        String origin = "Apply";
        StringBuilder stringBuilder = new StringBuilder();
        CompletableFuture cf = CompletableFuture.completedFuture(origin).thenApplyAsync(s -> s.toUpperCase())
                .acceptEither(CompletableFuture.completedFuture(origin).thenApplyAsync(s -> s.toUpperCase()),s->stringBuilder.append(s).append("acceptToEither"));
        cf.join();
        System.out.println(stringBuilder.toString().endsWith("acceptToEither"));
    }

    /**
     * 在两个阶段都执行完后运行一个Runnable
     */
    static void runAfterBoth(){
        String original = "Message";
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture(original).thenApply(String::toUpperCase).runAfterBoth(
                CompletableFuture.completedFuture(original).thenApply(String::toLowerCase),
                () -> result.append("done"));
        System.out.println(result);
    }

    /**
     * 使用BiConsumer处理两个阶段的结果
     */
    static void thenAcceptBoth(){
        String original = "Message";
        StringBuilder result = new StringBuilder();
        CompletableFuture.completedFuture(original).thenApply(String::toUpperCase).thenAcceptBoth(
                CompletableFuture.completedFuture(original).thenApply(String::toLowerCase),
                (s1, s2) -> result.append(s1 + s2));
        System.out.println(result.toString());
    }

    /**
     * 异步使用BiFunction处理两个阶段的结果
     */
    static void thenCombineAsync() {
        String original = "Message";
        CompletableFuture cf = CompletableFuture.completedFuture(original)
                .thenApplyAsync(s -> s.toUpperCase())
                .thenCombine(CompletableFuture.completedFuture(original).thenApplyAsync(String::toLowerCase),
                        (s1, s2) -> s1 + s2);
        System.out.println(cf.join());
    }

    /**
     * 组合 CompletableFuture
     */
    static void thenCompose(){
        String original = "Message";
        CompletableFuture cf = CompletableFuture.completedFuture(original).thenApply(s -> s.toLowerCase())
                .thenCompose(upper -> CompletableFuture.completedFuture(original).thenApply(s -> s.toUpperCase())
                        .thenApply(s -> upper + s));
        System.out.println(cf.join());
    }

    /**
     * 当几个阶段中的一个完成，创建一个完成的阶段
     */
    static void anyOf() {
        StringBuilder result = new StringBuilder();
        List<String> messages = Arrays.asList("a", "b", "c");
        List<CompletableFuture> futures = messages.stream()
                .map(msg -> CompletableFuture.completedFuture(msg).thenApply(s -> s.toUpperCase()))
                .collect(Collectors.toList());
        CompletableFuture.anyOf(futures.toArray(new CompletableFuture[futures.size()])).whenComplete((res, th) -> {
            if(th == null) {
                System.out.println((String) res);
                result.append(res);
            }
        });
        System.out.println(result);
    }

    /**
     * 当所有的阶段都完成后创建一个阶段
     */
    static void allOf() {
        StringBuilder result = new StringBuilder();
        List<String> messages = Arrays.asList("a", "b", "c");
        List<CompletableFuture> futures = messages.stream()
                .map(msg -> CompletableFuture.completedFuture(msg).thenApply(s ->s.toUpperCase()))
                .collect(Collectors.toList());
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).whenComplete((v, th) -> {
            futures.forEach(cf ->
                            System.out.println(cf.getNow(null)));
            result.append("done");
        });
        System.out.println(result);
    }

    /**
     * 当所有的阶段都完成后异步地创建一个阶段
     */
    static void allOfAsync() {
        StringBuilder result = new StringBuilder();
        List<String> messages = Arrays.asList("a", "b", "c");
        List<CompletableFuture> futures = messages.stream()
                .map(msg -> CompletableFuture.completedFuture(msg).thenApplyAsync(s -> s.toUpperCase()))
                .collect(Collectors.toList());
        CompletableFuture allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
                .whenComplete((v, th) -> {
                    futures.forEach(cf ->
                            System.out.println(cf.getNow(null)));
                    result.append("done");
                });
        allOf.join();
        System.out.println(result);
    }

    /**
     * 首先异步调用cars方法获得Car的列表，它返回CompletionStage场景。cars消费一个远程的REST API。
     * 然后我们复合一个CompletionStage填写每个汽车的评分，通过rating(manufacturerId)返回一个CompletionStage, 它会异步地获取汽车的评分(可能又是一个REST API调用)
     * 当所有的汽车填好评分后，我们结束这个列表，所以我们调用allOf得到最终的阶段， 它在前面阶段所有阶段完成后才完成。
     * 在最终的阶段调用whenComplete(),我们打印出每个汽车和它的评分。
     * 因为每个汽车的实例都是独立的，得到每个汽车的评分都可以异步地执行，这会提高系统的性能(延迟)，而且，等待所有的汽车评分被处理使用的是allOf方法，而不是手工的线程等待(Thread#join() 或 a CountDownLatch)。
     */
    static void test(){
       /* cars().thenCompose(cars -> {
            List<CompletionStage> updatedCars = cars.stream()
                    .map(car -> rating(car.manufacturerId).thenApply(r -> {
                        car.setRating(r);
                        return car;
                    })).collect(Collectors.toList());

            CompletableFuture done = CompletableFuture
                    .allOf(updatedCars.toArray(new CompletableFuture[updatedCars.size()]));
            return done.thenApply(v -> updatedCars.stream().map(CompletionStage::toCompletableFuture)
                    .map(CompletableFuture::join).collect(Collectors.toList()));
        }).whenComplete((cars, th) -> {
            if (th == null) {
                cars.forEach(System.out::println);
            } else {
                throw new RuntimeException(th);
            }
        }).toCompletableFuture().join();*/
    }

    public static void main(String[] args) {
        //demo();
        //runAsyncExample();
        //thenApply();
        //thenApplyAsync();
        //thenApplyAsyncWithExecutor();
        //thenAccept();
        //thenAcceptAsync();
        //completeExceptionally();
        //cancel();
        //applyToEither();
        //acceptToEither();
        //thenAcceptBoth();
        //thenCombineAsync();
        //anyOf();
        //allOf();
        allOfAsync();

    }








































































    static void threadSleep(long times){
        try {
            Thread.sleep(times);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
