package com.leinuo.sort.heap;

import com.leinuo.sort.SystemInUtils;
import com.leinuo.sort.hash.linkHash.Link;

import java.io.IOException;
import java.util.Objects;

/**
 * Create by leinuo on 2020/3/4 上午10:08
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class HeapApp {
    public static void main(String[] args) throws IOException {
        int value,value2;
        Heap heap = new Heap(31);
        boolean success;
        heap.insert(70);
        heap.insert(40);
        heap.insert(50);
        heap.insert(20);
        heap.insert(60);
        heap.insert(100);
        heap.insert(80);
        heap.insert(30);
        heap.insert(10);
        heap.insert(90);

        while (true){
            System.out.printf("Enter first letter of show,insert,remove,change:");
            int choice = SystemInUtils.getChar();
            switch (choice){
                case 's':
                    heap.display();
                    break;
                case 'i':
                    System.out.println("Enter value to insert:");
                    value = SystemInUtils.getInt();
                    success = heap.insert(value);
                    if(!success){
                        System.out.println("can not insert;heap is full!");
                    }
                    break;
                case 'r':

                    if(!heap.isEmpty()){
                        heap.remove();
                    }else {
                        System.out.println("heap isEmpty!");
                    }
                    break;
                case 'c':
                    System.out.println("Enter current index of item:");
                    value = SystemInUtils.getInt();
                    System.out.println("Enter a new key:");
                    value2 = SystemInUtils.getInt();
                    success = heap.change(value,value2);
                    if(!success){
                        System.out.println("invalid index!");
                    }
                    break;
                case 'e':
                    System.exit(0);
                default:
                    System.out.println("no case");
            }
        }

    }
}
