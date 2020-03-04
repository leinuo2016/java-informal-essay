package com.leinuo.dataStructuresAndAlgorithms.heap;

import com.leinuo.dataStructuresAndAlgorithms.SystemInUtils;

import java.io.IOException;

/**
 * Create by leinuo on 2020/3/4 上午11:05
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class HeapSortApp {
    public static void main(String[] args) throws IOException {
        int size ,j;
        System.out.println("Enter size:");
        size = SystemInUtils.getInt();
        Heap heap = new Heap(size);
        for(j=0;j<size;j++){
            int random = (int)(Math.random()*100);
            Node newNode = new Node(random);
            heap.insertAt(j,newNode);
            heap.incrementSize();
        }
        System.out.print("\nRandom: ");
        heap.display();
        heap.displayArray();
        for(j=size/2-1;j>=0;j--)
            heap.trickleDown(j);
        System.out.print("\nheap: ");
        heap.display();
        for(j=size-1;j>=0;j--){
            Node biggestNode = heap.remove();
            heap.insertAt(j,biggestNode);
        }
        System.out.print("\nsort: ");
        heap.display();
        heap.displayArray();
        //数据结构与算法　　Data Structures and Algorithms
    }
}
