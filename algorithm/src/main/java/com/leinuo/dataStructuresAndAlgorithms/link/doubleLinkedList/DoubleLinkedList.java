package com.leinuo.dataStructuresAndAlgorithms.link.doubleLinkedList;

import java.util.Objects;

/**
 * Create by leinuo on 2020/2/21 下午5:20
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 * 双向链表
 */
public class DoubleLinkedList {
    private DoubleLink first;
    private DoubleLink last;
    public DoubleLinkedList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public void insertFirst(int key){
        DoubleLink doubleLink = new DoubleLink(key);
        if(isEmpty()){
            last = doubleLink;
        }else {
            first.previous=doubleLink;
        }
        doubleLink.next=first;
        first=doubleLink;
    }

    public void insertLast(int key){
        DoubleLink doubleLink = new DoubleLink(key);
        if(isEmpty()){
            first=doubleLink;
        }else {
            last.next=doubleLink;
            doubleLink.previous=last;
        }
        last=doubleLink;
    }

    public DoubleLink deleteFirst(){
        DoubleLink temp = first;
        if(Objects.isNull(first.next)){
            return null;
        }else {
            first.next.previous=null;
        }
        first = first.next;
        return temp;
    }

    public DoubleLink deleteLast(){
        DoubleLink temp = last;
        if(isEmpty()){
            return null;
        }else {
            last.previous.next=null;
        }
        last = last.previous;
        return temp;
    }

    public boolean insertAfter(int key,int value){
        if(isEmpty()){
            return false;
        }
        DoubleLink current = first;
        while (current.anInt!=key){
            current=current.next;
            if(Objects.isNull(current)){
                return false;
            }
        }
        DoubleLink newLink = new DoubleLink(value);
        if(current==last){
            newLink.next=null;
            last= newLink;
        }else {
            newLink.next=current.next;
            current.next.previous=newLink;
        }
        newLink.previous = current;
        current.next = newLink;
        return true;
    }

    public DoubleLink delete(int key){
        if(isEmpty()){
            return null;
        }
        DoubleLink current = first;
        while (current.anInt!=key){
            current = current.next;
            if(Objects.isNull(current)){
                return null;
            }
        }
        if(current==first){
            first = current.next;
            first.previous=null;
        }else {
            current.previous.next = current.next;
        }
        if(current==last){
            last = current.previous;
            last.next=null;
        }else {
            current.next.previous = current.previous;
        }
        return current;
    }

    public DoubleLink delete1(int key){
        if(isEmpty()){
            return null;
        }
        DoubleLink current = first;
        while (current.anInt!=key){
            current = current.next;
            if(Objects.isNull(current)){
                return null;
            }
        }
        if(current==first){
            first = current.next;
            first.previous=null;
        }else if(current==last){
            last = current.previous;
            last.next=null;
        }else {
            current.next.previous = current.previous;
            current.previous.next = current.next;
        }
        return current;
    }

    public void displayForward(){
        if(isEmpty()){
            System.out.println("isEmpty");
            return;
        }
        System.out.println("displayForward");
        DoubleLink current = first;
        while (Objects.nonNull(current)){
            current.display();
            current = current.next;
        }
    }

    public void displayBackward(){
        if(isEmpty()){
            System.out.println("isEmpty");
            return;
        }
        System.out.println("displayBackward");
        DoubleLink current = last;
        while (Objects.nonNull(current)){
            current.display();
            current = current.previous;
        }
    }
}
