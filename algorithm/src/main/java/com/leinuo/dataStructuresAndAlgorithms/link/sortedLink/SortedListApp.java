package com.leinuo.dataStructuresAndAlgorithms.link.sortedLink;

import com.leinuo.dataStructuresAndAlgorithms.link.Link;

import java.util.Arrays;
import java.util.Random;

/**
 * Create by leinuo on 2020/2/21 下午2:30
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class SortedListApp {
    public static void main(String[] args) {
        SortedList sortedList = new SortedList();
        sortedList.insert(2);
        sortedList.insert(8);
        sortedList.insert(3);
        sortedList.insert(7);
        sortedList.insert(1);
        sortedList.insert(7);
        sortedList.display();
        System.out.println("remove");
        Link link = sortedList.remove();
        link.display();
        System.out.println("remove--");
        sortedList.display();
        //有序链表为数组排序
        System.out.println("-------------array sort------------");
        int size = 10;
        Link[] linkArray = new Link[size];
        int a;
        for (int i = 0; i < size ; i++) {
            a = new Random().nextInt(100);
            Link newLink = new Link(a,1.11);
            linkArray[i] = newLink;
        }
        System.out.println("array sort before");
        Arrays.stream(linkArray).forEach(link1 -> System.out.println(link1.aInt));
        System.out.println("array sort after");
        SortedList sortedList1 = new SortedList(linkArray);
        sortedList1.display();
    }
}
