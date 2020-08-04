package com.leinuo.guava.string;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Create by leinuo on 2020/3/30 下午6:01
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class ListApp {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("11","22","33","44");
        for(int i=0;i<list.size();i++){
            list.set(i,list.get(i)+" "+i);
        }
        list.stream().forEach(s -> System.out.println(s));
    }
}
