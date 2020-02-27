package com.leinuo.json.completableFuture;

import com.google.common.base.Stopwatch;
import com.sun.xml.internal.ws.util.CompletedFuture;
import org.checkerframework.checker.units.qual.C;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Create by leinuo on 2020/2/27 上午9:19
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class UserService {
    private Supplier<UserQueryUtils> userQueryUtilsSupplier = UserQueryUtils::new;
    Map<String,FutureTask<String>> futureMap = new HashMap<>();
    public User converUserByCompletableFuture(User user){
        UserQuerySupplier userQuerySupplier1 = new UserQuerySupplier(user.getCarId(),"car",userQueryUtilsSupplier.get());
        CompletableFuture<String> getCarDesc = CompletableFuture.supplyAsync(userQuerySupplier1);
        getCarDesc.thenAccept(new Consumer<String>() {
            @Override
            public void accept(String s) {
                user.setCarDesc(s);
            }
        });

        UserQuerySupplier userQuerySupplier2 = new UserQuerySupplier(user.getHomeId(),"home",userQueryUtilsSupplier.get());
        CompletableFuture<String> getHomeDesc = CompletableFuture.supplyAsync(userQuerySupplier2);
        getHomeDesc.thenAccept(new Consumer<String>() {
            @Override
            public void accept(String s) {
                user.setHomeDesc(s);
            }
        });

        UserQuerySupplier userQuerySupplier3 = new UserQuerySupplier(user.getCarId(),"jop",userQueryUtilsSupplier.get());
        CompletableFuture<String> getJopDesc = CompletableFuture.supplyAsync(userQuerySupplier3);
        getJopDesc.thenAccept(new Consumer<String>() {
            @Override
            public void accept(String s) {
                user.setJopDesc(s);
            }
        });
        CompletableFuture<Void> getUserInfo = CompletableFuture.allOf(getCarDesc,getHomeDesc,getJopDesc);
        getUserInfo.thenAccept(new Consumer<Void>() {
            @Override
            public void accept(Void aVoid) {
               // System.out.println("查询完毕！");
            }
        });
        getUserInfo.join();
        return user;
    }

    /**
     * 使用 FutureTask 来优化查询
     * @param user
     * @return
     */
    public User converUserByFutureTask(User user) {
        Callable<String> homeCall = new Callable() {
            @Override
            public Object call() throws Exception {
                return userQueryUtilsSupplier.get().queryHome(user.getHomeId());
            }
        };
        FutureTask<String> getHomeDesc = new FutureTask<>(homeCall);
        new Thread(getHomeDesc).start();
        futureMap.put("homeCall",getHomeDesc);

        Callable<String> carCall = new Callable() {
            @Override
            public Object call() throws Exception {
                return userQueryUtilsSupplier.get().queryCar(user.getCarId());
            }
        };
        FutureTask<String> getCarDesc = new FutureTask<>(carCall);
        new Thread(getCarDesc).start();
        futureMap.put("carCall",getCarDesc);

        Callable<String> jopCall = new Callable() {
            @Override
            public Object call() throws Exception {
                return userQueryUtilsSupplier.get().queryJop(user.getJopId());
            }
        };
        FutureTask<String> getJopDesc = new FutureTask<>(jopCall);
        new Thread(getJopDesc).start();
        futureMap.put("jopCall",getJopDesc);

        try {
            user.setHomeDesc(futureMap.get("homeCall").get());
            user.setCarDesc(futureMap.get("carCall").get());
            user.setJopDesc(futureMap.get("jopCall").get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
       // System.out.println("查询完毕！");
        return user;
    }

    /**
     * CompletableFuture明显优于FutureTask
     * 10000
     * converUserByFutureTask times = 2167
     * converUserByCompletableFuture times = 135
     * @param args
     */
    public static void main(String[] args) {
        Long begin = System.currentTimeMillis();
        List<User> userList = Collections.synchronizedList(new ArrayList<>());
        List<User> userList2 = Collections.synchronizedList(new ArrayList<>());
        User user;
        UserService userService = new UserService();
        for(int i=0;i<10000;i++){
            user = new User(i,"userName"+i,i,i,i);
            userList.add(user);
            userList2.add(user);
        }
        userList.stream().map(user1 -> {
            user1 = userService.converUserByFutureTask(user1);
            return user1;
        }).collect(Collectors.toList());
        Long time = System.currentTimeMillis();
        System.out.println("converUserByFutureTask times = " + (time-begin));
        userList2.stream().map(user1 -> {
             user1 = userService.converUserByCompletableFuture(user1);
            return user1;
        }).collect(Collectors.toList());
        System.out.println("converUserByCompletableFuture times = " + (System.currentTimeMillis()-time));
    }
}
