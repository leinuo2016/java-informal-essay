package com.leinuo.sort.insertion;

import com.leinuo.sort.selection.ArraySelection;

import java.util.Random;

/**
 * Create by leinuo on 2020/2/4 下午10:08
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 *
 * 冒泡排序
 */
public class InsertionSortApp {

    public static void main(String[] args) {
        int size = 30;
        ArrayInsertion arrayInsertion = new ArrayInsertion(size);
        int value;
        for(int i=0;i<size;i++){
            value = new Random().nextInt(100);
//           if(!arraysel.containt(value)){
//               arraysel.insert(value);
//           };

            arrayInsertion.insert(value);
        }
        arrayInsertion.display();
        long time1 = System.currentTimeMillis();
        arrayInsertion.insertionSort();
        long time2 = System.currentTimeMillis();
        System.out.println("耗时："+(time2-time1));
        arrayInsertion.display();
    }
}
