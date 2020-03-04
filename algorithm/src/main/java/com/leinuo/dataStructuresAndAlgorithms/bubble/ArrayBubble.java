package com.leinuo.dataStructuresAndAlgorithms.bubble;

import java.util.Arrays;

/**
 * Create by leinuo on 2020/2/4 下午9:41
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class ArrayBubble {

    private int[] a;
    private int next;

    public ArrayBubble(int max) {
        this.a = new int[max];
        this.next=0;
    }

    public void insert(int value){
        a[next]=value;
        next++;
    }

    public void display(){
        Arrays.stream(a).forEach(value -> System.out.printf(value+" "));
        int sum = Arrays.stream(a).reduce(0,(a, b) -> a+b);
        System.out.println(String.format("a[]之和：%s",sum));
    }

    public void bubbleSort(){
        int i,j;
        for(i=next-1;i>0;i--){
            for(j=0;j<i;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j]=a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    public void bubbleSortDec(){
        int i,j;
        for(i=next-1;i>0;i--){
            for(j=0;j<i;j++){
                if(a[j]<a[j+1]){
                    int temp = a[j];
                    a[j]=a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
}
