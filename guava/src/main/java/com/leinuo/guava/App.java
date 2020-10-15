package com.leinuo.guava;

import com.google.common.base.Strings;
import com.sun.org.apache.xpath.internal.objects.XNumber;
import javafx.beans.property.SimpleMapProperty;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Create by leinuo on 2020/3/26 下午4:32
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class App {
    /**
     * 1 假设一个元素为单词的流，
     * 计算每个单词出现的次数。假设输入如下，
     * 则返回值为一 个形如
     * [John → 3, Paul → 2, George → 1] 的
     * Map：
     * Stream<String> names = Stream.of("John", "Paul", "George", "John", "Paul", "John");
     */

    public static void main(String[] args) {
        //统计出现次数
        //组合元素
        //返回list
        Stream<String> names = Stream.of("John", "Paul", "George", "John", "Paul", "John");

        test1(names);

        test2(names);

        test3(names);
    }

    public static void test1(Stream<String> names){
        List<String> strings = names.collect(Collectors.toList());
        Map<String,Integer> map = new LinkedHashMap<>();
        strings.stream().forEach(name->{
            if(map.containsKey(name)){
                map.put(name,map.get(name)+1);
            }else {
                map.put(name,1);
            }
        });
        List<String> result = new ArrayList(map.keySet());
        result = result.stream().map(name-> name+" → "+map.get(name)).collect(Collectors.toList());
        System.out.println(result);
    }

    public static void test2(Stream<String> names){
        List<String> strings = names.collect(Collectors.toList());
        Map<String,Long> map = strings.stream().collect(Collectors.groupingBy(name->name, LinkedHashMap::new,Collectors.counting()));
        List<String> result = new ArrayList(map.keySet());
        result = result.stream().map(name-> name+" → "+map.get(name)).collect(Collectors.toList());
        System.out.println(result);
    }


    public static void test3(Stream<String> names){
        List<String> strings = names.collect(Collectors.toList());
        List<String> temp = strings.stream().collect(Collectors.toList());
        List<String> result = strings.stream().distinct().map(name->{
            long num = temp.stream().filter(name1->name.equals(name1)).count();
            return name+" → "+num;
        }).collect(Collectors.toList());
        System.out.println(result);
    }


}
