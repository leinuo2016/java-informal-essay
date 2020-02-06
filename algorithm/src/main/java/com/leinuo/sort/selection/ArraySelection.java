package com.leinuo.sort.selection;

import java.util.Arrays;

/**
 * Create by leinuo on 2020/2/6 下午4:44
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class ArraySelection {
    private int[] a;
    private int next;

    public ArraySelection(int max) {
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

    public void selectSort() {
        int out, in, min;
        for (out = 0; out < next - 1; out++) {
            min = out;
            for (in = out + 1; in < next; in++){
                if (a[in] < a[min])
                    min = in;
            }
                swap(out, min);
        }
    }

    private void swap(int one, int two) {
        int temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }


    public boolean containt(int value) {
        return Arrays.stream(a).anyMatch(value1 -> value == value1);
    }
}
