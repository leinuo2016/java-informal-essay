package com.leinuo.completableFutureDemo;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by leinuo on 2020/12/25
 * qq:1321404703 https://github.com/leinuo2016
 */
public class StreamTest {

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(3,1,4,433,453,100,45,44,56,100,77);
        //System.out.println(list.parallelStream().sorted().collect(Collectors.toList()).toString());
        StreamTest streamTest = new StreamTest();
        streamTest.test1();
    }

    public void test1() {

        List<Integer> list = Arrays.asList(1, 2, 5, 4, 3);
//注意 注意 注意 我只改动了这里 生成了一个并行流
        List<Integer> collect = list.parallelStream()
                .map(this::map1)
                .map(this::map2)
                .sorted((o1, o2) -> o2 - o1)
                .map(this::map3)
                .map(this::map4)
                .sorted()
                .limit(4)
                .collect(Collectors.toList());
        System.out.println(collect);

    }

    private Integer map1(Integer i) {
        int r = i * 10;
        System.out.println("线程:" + Thread.currentThread().getName() + "\t方法 map1\t" + "收到:" + i + "\t" + "输出:" + r);
        return r;
    }

    private Integer map2(Integer i) {
        int r = i * 10;
        System.out.println("线程:" + Thread.currentThread().getName() + "\t方法 map2\t" + "收到:" + i + "\t" + "输出:" + r);
        return r;
    }

    private Integer map3(Integer i) {
        int r = i * 10;
        System.out.println("线程:" + Thread.currentThread().getName() + "\t方法 map3\t" + "收到:" + i + "\t" + "输出:" + r);
        return r;
    }

    private Integer map4(Integer i) {
        int r = i * 10;
        System.out.println("线程:" + Thread.currentThread().getName() + "\t方法 map4\t" + "收到:" + i + "\t" + "输出:" + r);
        return r;
    }
}
