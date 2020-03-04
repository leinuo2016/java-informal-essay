package com.leinuo.dataStructuresAndAlgorithms.link.doubleLinkedList;

/**
 * Create by leinuo on 2020/2/21 下午5:20
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class DoubleLink {
    public int anInt;
    public DoubleLink next;
    public DoubleLink previous;

    public DoubleLink(int a){
        anInt = a;
    }

    public void display(){
        System.out.print(anInt+" ");
    }

}
