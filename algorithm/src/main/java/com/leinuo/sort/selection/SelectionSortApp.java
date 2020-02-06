package com.leinuo.sort.selection;

import java.util.Random;

/**
 * Create by leinuo on 2020/2/4 下午10:08
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 *
 * 冒泡排序
 */
public class SelectionSortApp {

    public static void main(String[] args) {
        int size = 30;
        ArraySelection arraysel = new ArraySelection(size);
        int value;
        for(int i=0;i<size;i++){
            value = new Random().nextInt(100);
//           if(!arraysel.containt(value)){
//               arraysel.insert(value);
//           };

            arraysel.insert(value);
        }
        arraysel.display();
        long time1 = System.currentTimeMillis();
        arraysel.selectSort();
        long time2 = System.currentTimeMillis();
        System.out.println("耗时："+(time2-time1));
        arraysel.display();
    }
}
