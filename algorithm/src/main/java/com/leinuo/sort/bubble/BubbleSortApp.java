package com.leinuo.sort.bubble;

import java.util.Random;

/**
 * Create by leinuo on 2020/2/4 下午10:08
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 *
 * 冒泡排序
 */
public class BubbleSortApp {

    public static void main(String[] args) {
        int size = 10;
        ArrayBubble arrayBub = new ArrayBubble(size);
        for(int i=0;i<size;i++){
            arrayBub.insert(new Random().nextInt(100));
        }
        arrayBub.display();
        long time1 = System.currentTimeMillis();
        arrayBub.bubbleSort();
        long time2 = System.currentTimeMillis();
        System.out.println("耗时："+(time2-time1));
        arrayBub.display();
        arrayBub.bubbleSortDec();
        arrayBub.display();
    }
}
