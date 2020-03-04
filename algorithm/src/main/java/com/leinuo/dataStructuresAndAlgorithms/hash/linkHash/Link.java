package com.leinuo.dataStructuresAndAlgorithms.hash.linkHash;

/**
 * Create by leinuo on 2020/2/17 下午4:28
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class Link {
    public int aInt;
    public Link next;

    public Link(int aInt) {
        this.aInt = aInt;
    }

    public int getKey(){
        return aInt;
    }

    public void display(){
        System.out.print(String.format("{%s}",aInt));
    }
}
