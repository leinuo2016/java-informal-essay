package com.leinuo.sort.insertion;

import java.util.Arrays;

/**
 * Create by leinuo on 2020/2/6 下午4:44
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class ArrayInsertion {
    private int[] a;
    private int next;

    public ArrayInsertion(int max) {
        this.a = new int[max];
        this.next = 0;
    }

    public void insert(int value) {
        a[next] = value;
        next++;
    }

    public void display() {
        Arrays.stream(a).forEach(value -> System.out.printf(value + " "));
        int sum = Arrays.stream(a).reduce(0, (a, b) -> a + b);
        System.out.println(String.format("a[]之和：%s", sum));
    }

    public void insertionSort() {
        int out, in;
        for (out = 1; out < next; out++) {
            int temp=a[out];
            in=out;
            while (in>0&&a[in-1]>=temp){
                a[in]=a[in-1];
                --in;
            }
            a[in]=temp;
        }
    }
    public boolean containt(int value) {
        return Arrays.stream(a).anyMatch(value1 -> value == value1);
    }
}
