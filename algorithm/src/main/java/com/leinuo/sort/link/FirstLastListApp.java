package com.leinuo.sort.link;

/**
 * Create by leinuo on 2020/2/21 上午9:24
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class FirstLastListApp {
    public static void main(String[] args) {
        System.out.println("first-------------------------");
        FirstLastList firstList = new FirstLastList();
        firstList.insertFirst(1,1.1);
        firstList.insertFirst(2,2.1);
        firstList.insertFirst(3,3.1);
        firstList.insertFirst(4,4.1);
        firstList.disaply();
        firstList.deleteFirst();
        System.out.println("删除第一个之后");
        firstList.disaply();
        Link link = firstList.getLast();
        System.out.println("获取最后一个");
        link.display();
        System.out.println("last-------------------------");
        FirstLastList lastList = new FirstLastList();
        lastList.insertFirst(5,5.1);
        lastList.insertFirst(6,6.1);
        lastList.insertFirst(7,7.1);
        lastList.insertFirst(8,8.1);
        lastList.disaply();
        lastList.deleteFirst();
        System.out.println("删除第一个之后");
        lastList.disaply();
        link = lastList.getLast();
        System.out.println("获取最后一个");
        link.display();
    }
}
