package com.leinuo.dataStructuresAndAlgorithms.link.doubleLinkedList;

/**
 * Create by leinuo on 2020/2/21 下午5:20
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class DoubleLinkedListApp {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedListFirst = new DoubleLinkedList();
        doubleLinkedListFirst.insertFirst(1);
        doubleLinkedListFirst.insertFirst(2);
        doubleLinkedListFirst.insertFirst(3);
        doubleLinkedListFirst.insertFirst(4);
        doubleLinkedListFirst.insertFirst(5);
        doubleLinkedListFirst.insertLast(2);
        doubleLinkedListFirst.displayForward();
        System.out.println("");
        doubleLinkedListFirst.displayBackward();
        System.out.println("");
        doubleLinkedListFirst.deleteFirst().display();
        System.out.println("");
        doubleLinkedListFirst.displayForward();
        System.out.println("");
        doubleLinkedListFirst.deleteLast().display();
        System.out.println("");
        doubleLinkedListFirst.displayForward();
        System.out.println("");
        doubleLinkedListFirst.insertAfter(2,7);
        System.out.println("");
        doubleLinkedListFirst.displayForward();
        System.out.println("");
        System.out.println(doubleLinkedListFirst.delete(7).anInt);
        doubleLinkedListFirst.displayForward();
        System.out.println("");
        System.out.println(doubleLinkedListFirst.delete1(4).anInt);
        doubleLinkedListFirst.displayForward();
        System.out.println("");
        DoubleLinkedList doubleLinkedListLast = new DoubleLinkedList();
        doubleLinkedListLast.insertLast(6);
        doubleLinkedListLast.insertLast(7);
        doubleLinkedListLast.insertLast(8);
        doubleLinkedListLast.insertLast(9);
        doubleLinkedListLast.insertLast(10);
        doubleLinkedListLast.displayForward();
        System.out.println("");
        doubleLinkedListLast.displayBackward();


    }
}
