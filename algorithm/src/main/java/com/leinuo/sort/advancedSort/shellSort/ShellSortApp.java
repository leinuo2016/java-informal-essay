package com.leinuo.sort.advancedSort.shellSort;

/**
 * Create by leinuo on 2020/2/27 上午11:15
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class ShellSortApp {
    public static void main(String[] args) {
        int maxSize = 100;
        ArraySh arr = new ArraySh(maxSize);
        int n;
        for (int j = 0; j < maxSize; j++) {
            n = (int) (Math.random()*999);
            arr.insert(n);
        }
        arr.display();
        arr.shellSort();
        arr.display();
    }
}
