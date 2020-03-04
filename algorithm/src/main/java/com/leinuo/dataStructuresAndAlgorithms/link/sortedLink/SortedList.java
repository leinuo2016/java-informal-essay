package com.leinuo.dataStructuresAndAlgorithms.link.sortedLink;

import com.leinuo.dataStructuresAndAlgorithms.link.Link;

import java.util.Objects;

/**
 * Create by leinuo on 2020/2/21 上午11:20
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class SortedList {
    private Link first;

    public SortedList(){
        first=null;
    }

    public SortedList(Link[] linkArr){
        first = null;
        for(int i=0;i<linkArr.length;i++){
            insert(linkArr[i]);
        }
    }

    private void insert(Link link) {
        Link temp = null;
        Link current = first;
        while (Objects.nonNull(current)&&link.aInt>current.aInt){
          temp = current;
          current = current.next;
        }
        if(Objects.isNull(temp)){
            first = link;
        }else {
            temp.next = link;
        }
        link.next = current;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public void insert(int key){
        Link link = new Link(key,2.22);
        Link temp = null;
        Link current = first;
        while (Objects.nonNull(current)&&key>current.aInt){
            temp = current;
            current = current.next;
        }
        if(Objects.isNull(temp)){
            first = link;
        }else {
            temp.next=link;
        }
        link.next = current;
    }

    public Link remove(){
        if(isEmpty()){
            return null;
        }
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("isEmpty");
            return;
        }
        Link current = first;
        while (Objects.nonNull(current)){
            current.display();
            current = current.next;
        }

    }
}
