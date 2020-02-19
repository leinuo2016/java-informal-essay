package com.leinuo.sort.link;

/**
 * Create by leinuo on 2020/2/17 下午4:28
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class Link {
    public int aInt;
    public double aDouble;
    public Link next;

    public Link(int aInt, double aDouble) {
        this.aInt = aInt;
        this.aDouble = aDouble;
    }

    public void display(){
        System.out.println(String.format("{%s,%s}",aInt,aDouble));
    }
}
