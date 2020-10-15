package com.leinuo.vavr;

import io.vavr.*;
import io.vavr.collection.List;
import io.vavr.collection.Map;
import io.vavr.collection.Stream;
import io.vavr.control.Either;
import io.vavr.control.Try;

import java.util.ArrayList;
import java.util.Collections;

import static io.vavr.API.*;

/**
 * Create by leinuo on 2020/10/12
 * qq:1321404703 https://github.com/leinuo2016
 */
public class App {

    public static String join(String... words) {
        System.out.println(List.of(words).mkString("|"));
        return List.of(words)
                .intersperse(",")
                .foldLeft(new StringBuilder(), StringBuilder::append)
                .toString();
    }

    /**
     * 元组最为方便的一种数据结构，将任意类型任意多个数据统一放到一个对象中，无论作为参数传递还是结果返回都可以实现多个不同类型数据的传递
     */
    public static void tupleTest() {
        Tuple2<String, Integer> tuple2 = Tuple.of("1nidd1", 22);
        System.out.println(tuple2._1);
        System.out.println(tuple2._2);
    }

    /**
     * 简介的异常处理，不会因为异常而影响程序的运行，代码也更加简练
     */
    public static void tryTest() {
        Try<Integer> result = Try.of(() -> 1 / 0);
        System.out.println(result.isSuccess());
        Try<Integer> result1 = Try.of(() -> 1 / 1);
        System.out.println(result1.get());

        // Try<Integer> result = Try.of(() -> 1 / 0);

    }

    /**
     * 比java自带的更好用更好理解，
     */
    public static void functionTest() {
        Function0<String> result = () -> NullPointerException.class.getName();
        System.out.println(result.apply());
        Function5<String, String, String, String, String, String> concat =
                (a, b, c, d, e) -> a + b + c + d + e;
        String finalString = concat.apply(
                "Hello ", "world", "! ", "Learn ", "Vavr");
        System.out.println(finalString);
        Function2<Integer, Integer, Integer> sum = Function2.of(Integer::sum);
        System.out.println(sum.apply(2, 13));
    }


    /**
     * 有链表实现的list,具有不可变性，线程安全，每一次prepend都会返回一个新的list,而不会改变原来的list,并且通过toJavaList和java库的list兼容
     */
    public static void listTest() {
        List<Integer> list = List.of(1, 5, 6);
        int sum = list.sum().intValue();
        System.out.println(list.size() + "，" + list.length() + "," + sum);
        System.out.println( list.tail().prepend(3).toString());
        sum = list.sum().intValue();
        System.out.println(list.toString());
        System.out.println(list.size() + "，" + list.length() + "," + sum);

        List<Integer> list1 = List.of(1, 2, 3);
        List<Integer> list2 = list1.tail().prepend(0);
        System.out.println(list1.toString()+","+list2.toString());
        System.out.println(list2.prepend(39).toString());
        java.util.List list3 = list1.toJavaList();
        list3.add(99);
        System.out.println(list3.toString());

    }

    public static void listTest1() {
        List<Integer> list = List.of(1, 5, 6);
        System.out.println(list.map(v->v+10));
        Function1<Integer, java.util.List> fun = (v)-> {ArrayList arrayList = new ArrayList();
        arrayList.add(v);return arrayList;};
        java.util.List apply = fun.apply(2);
        System.out.println(apply.toString());
        System.out.println(List.of(1, 2, 3).toJavaList(java.util.ArrayList::new).toString());

    }

    /**
     * lazy延迟计算，只有在get时才开始计算
     */
    public static void lazyTest() {
        Lazy<Double> lazy = Lazy.of(Math::random);
        System.out.println(lazy.isEvaluated());
        Double d1 = lazy.get();
        System.out.println(lazy.isEvaluated());
        Double d2 = lazy.get();
        System.out.println(lazy.isEvaluated());
        System.out.println(d1 + "," + d2);
    }

    /**
     * 替代switch case,代码简洁，语义明确
     * @param input
     */
    public static void patternTest( int input) {
        String output = Match(input).of(
                Case($(2), "1"),
                Case($(2), "2"),
                Case($(3), "3"),
                Case($(), "x")
        );
        System.out.println(output);
    }

    /**
     * 替代switch case,代码简洁，语义明确
     * @param input
     */
    public static void patternTest1( int input) {
         Match(input).of(
                Case($(integer -> input>3&&input<8),o-> run(()-> System.out.println("1"))),
                //Case($(2),o-> run(()-> {throw new NullPointerException();})),
                 Case($(2),o-> run(()-> System.out.println("2"))),
                Case($(3),o-> run(()-> System.out.println("3"))),
                Case($(), o->run(()-> System.out.println("x")))
        );
    }
    public static void patternTest2( ) {
        int value = -1;
        Match(value).of(
                Case($(v -> v > 0), o -> run(() -> System.out.println("> 0"))),
                Case($(0), o -> run(() -> System.out.println("0"))),
                Case($(), o -> run(() -> System.out.println("< 0")))
        );
// 输出<  0
    }


    /**
     * 对当前函数调用curried()方法，得到一个当前函数的柯理化函数,可以继续调用该函数的方法
     */
    public static void curry(){
        Function3<Integer, Integer, Integer, Integer> function3 = (v1, v2, v3)
                -> (v1 + v2) * v3;
        int result =
                function3.curried().apply(1).curried().apply(2).curried().apply(2);
        System.out.println(result);
    }

    public static void eitherTest(){
        Either<Integer,String> either = 1==1?Either.left(new Integer(2)):Either.right("dd");
        either.map(String::toString).mapLeft(Integer::intValue);
        System.out.println(either);
    }

    public static void streamTest(){
        Map<Boolean, List<Integer>> booleanListMap = Stream.ofAll(1, 2, 3, 4, 5)
                .groupBy(v -> v % 2 == 0)
                .mapValues(Value::toList);
        System.out.println(booleanListMap);
// 输出 LinkedHashMap((false, List(1, 3, 5)), (true, List(2, 4)))

        Tuple2<List<Integer>, List<Integer>> listTuple2 = Stream.ofAll(1, 2, 3, 4)
                .partition(v -> v > 2)
                .map(Value::toList, Value::toList);
        System.out.println(listTuple2);
// 输出 (List(3, 4), List(1, 2))

        List<Integer> integers = Stream.ofAll(List.of("Hello", "World", "a"))
                .scanLeft(0, (sum, str) -> sum + str.length())
                .toList();
        System.out.println(integers);
// 输出 List(0, 5, 10, 11)

        List<Tuple2<Integer, String>> tuple2List = Stream.ofAll(1, 2, 3)
                .zip(List.of("a", "b"))
                .toList();
        System.out.println(tuple2List);
// 输出 List((1, a), (2, b))
    }

    public static void propertyTest(){
        //System.out.println(Stream.from(1).filter(i -> i % 2 == 0).asJava().toString());
        System.out.println(Stream.range(1,3).filter(i -> i % 2 == 0).asJava().toString());
    }



    public static void main(String[] args) {

       // patternTest(2);
       // patternTest(6);

       // System.out.println(join("22","33","44"));

       // tupleTest();

       // tryTest();

      //  functionTest();

      //   listTest();

      //  listTest1();

      //  streamTest();

        propertyTest();

      //   curry();

      //   eitherTest();

      //  patternTest1(2);
      //  patternTest1(9);
      //  patternTest2();

//        lazyTest();

//        System.out.println("---------------");

//        lazyTest();
    }

}
