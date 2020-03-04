package com.leinuo.dataStructuresAndAlgorithms.link;

import java.util.Objects;

/**
 * Create by leinuo on 2020/2/20 下午5:25
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 *
 * 双端链表
 */
public class FirstLastList {
    private Link first;
    private Link last;

    public FirstLastList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public void insertFirst(int id,double dd){
        Link link = new Link(id,dd);
        if(isEmpty()){
            last=link;
        }
        link.next=first;
        first = link;
    }

    public void insertLast(int id,double dd){
        Link link = new Link(id,dd);
        if(isEmpty()){
            first=link;
        }else {
            last.next=link;
        }
        last = link;
    }

    public int deleteFirst(){
        if(isEmpty()){
            return 0;
        }
        int temp = first.aInt;
        if(first.next==null){
            last=null;
        }
        first = first.next;
        return temp;
    }

    public Link getLast(){
        return last;
    }

    public void disaply(){
        if(isEmpty()){
            System.out.println("list is empty");
            return;
        }
        Link current = first;
        while (Objects.nonNull(current)){
            current.display();
            current = current.next;
        }
    }

}

