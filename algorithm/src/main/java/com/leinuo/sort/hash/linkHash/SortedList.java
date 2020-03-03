package com.leinuo.sort.hash.linkHash;


import java.util.List;
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

    public void insert(Link link) {
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
        Link link = new Link(key);
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

    public void delete(int key){
        if(isEmpty()){
            return;
        }
        Link previous = null;
        Link current = first;
        while (Objects.nonNull(current)&&key!=current.getKey()){
            previous = current;
            current = current.next;
        }
        if(Objects.isNull(previous)){
            first = first.next;
        }else {
            previous.next = current.next;
        }
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
        System.out.println(" ");
    }

    public Link find(int key) {
        Link current = first;
        while (Objects.nonNull(current)&&current.getKey()<=key)
        {
            if(current.getKey()==key){
                return current;
            }
            current = current.next;
        }
        return null;
    }
}
