package com.leinuo.function;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 * Create by leinuo on 2020/9/22
 * qq:1321404703 https://github.com/leinuo2016
 */
public class App {

    public static void main(String[] args) {
        /*FunctionUtils functionUtils = (a) -> {
            System.out.println("11");
            return a;
        };
        String str = functionUtils.hello("nihao");
        System.out.println(str);*/

        FunctionUtils functionUtils = (a, b) -> {
            //System.out.println("11");
            return a + b;
        };
        int str = functionUtils.add(578, 6);
       // System.out.println(str);

        //deal(num->{return getData(num-1,num*2);},t-> {System.out.println(t);});
        int a = 5;
        deal1(a,2*a,action3,consumer);

        deal3("a",2,biFunction2);




    }

    private static void deal4(String a, Object o) {
    }

    private static void deal3(String a, int a1, BiFunction<String, Integer, String> biFunction2) {
        System.out.println(biFunction2.apply(a,a1));
    }


    private static List<String> getData(Integer num, Integer pageSize) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            list.add(i+"");
        }
        // 因为查的不是数据库，会出现下标越界情况
        try {
            return list.subList(num,pageSize);
        }catch (Exception e) {
            return null;
        }
    }


    //Predicate 断言
    public static Predicate<Object> objectPredicate  = ps -> Predicate.isEqual(ps).test(ps);

    public static Predicate<String> predicate  = ps -> Predicate.isEqual(ps).test(ps);

    public static Predicate<String> predicate1  = ps -> (ps.equals("22"));

    public static Predicate<String> predicate2  = ps -> {return Predicate.isEqual(ps).or(objectPredicate).test(ps);};

    public static Predicate<String> predicate3  = ps -> {return Predicate.isEqual(ps).and(objectPredicate).test(ps);};

    //Consumer 消费一个数据
    public static Consumer<Integer> consumer = consumer -> {
        consumer = consumer * 10;
        System.out.println(consumer);
    };

    public static Consumer<String> stringConsumer = s -> {
        System.out.println(s+"1");
    };

    public static Consumer<String> stringConsumer1 = s -> {
        stringConsumer.accept(s);
        System.out.println(s+"2"); };

    public static Consumer<String> stringConsumerAnd = s -> stringConsumer1.andThen(stringConsumer);


    //Function输入T输出R的函数，输入输出类型可以变化也可以不变
    public static Function<Integer, Integer> action3 = action -> action*2;

    public static Function<String, String> action1 = action -> action;

    public static Function<String, String> action4 = action -> action+"r";

    public static Function<String, String> action2 = action -> action4.andThen(action1).apply(action);

    public static Function<String, String> action5 = action -> action4.compose(action1).apply(action);

    //Supplier提供一个数据
    public static Supplier<Integer> supplier = () -> 90;

    //UnaryOperator　一元函数（输入输出类型相同）继承自　Function
    public static UnaryOperator<String> unaryOperator = u -> u;


    //BiFunction 两个输入函数
    public static  BiFunction<String,Integer,String> biFunction = (a,c) -> c+a;

    public static  BiFunction<String,Integer,String> biFunction1 = (a,c) -> c+a+"ee";

    //aar
    public static  BiFunction<String,Integer,String> biFunction2 = (a,c) -> biFunction.andThen(action4).apply(a,c);


    //UnaryOperator　二元函数（输入输出类型相同）继承自　BiFunction
    public static BinaryOperator<String> binaryOperator = (a,c)-> a+c;

    public static BinaryOperator<String> binaryOperator1 = (a,c)-> binaryOperator.apply(a,c);



    public static <T> void deal(Function<Integer, List<T>> param, Consumer<T> consumer) {
        int num = 1;
        List<T> list = param.apply(1);
        while (true){
            if(list==null){
                break;
            }
            for(T t:list){
                if(t==null){
                    continue;
                }
                consumer.accept(t);
            }
            num++;
            list = param.apply(num);
        }
    }

    public static <T> void deal1(int a,int a2,Function<Integer, Integer> param, Consumer<T> consumer) {

        Integer list = param.apply(a);
        while (true){
            consumer.accept((T) list);
            a++;
            list = param.apply(a);
            if(a>a2){
                break;
            }
        }
    }

    public static <T> void deal2(int a,int a2,Function<Integer, Integer> param, Consumer<T> consumer) {

        Integer list = param.apply(a);
        while (true){
            consumer.accept((T) list);
            a++;
            list = param.apply(a);
            if(a>a2){
                break;
            }
        }
    }
}
