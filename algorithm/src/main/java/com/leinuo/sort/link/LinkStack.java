package com.leinuo.sort.link;

import java.util.Objects;

/**
 * Create by leinuo on 2020/2/21 上午9:56
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 *
 * 先进后出
 */
public class LinkStack {
    private LinkList linkList;

    public LinkStack(){
        linkList = new LinkList();
    }
    //压栈
    public void push(int a,double dd){
        linkList.insertFirst(a,dd);
    }

    public String pop(){
        Link link = linkList.deleteFirst();
        return Objects.nonNull(link) ?link.aInt+":"+link.aDouble:"isEmpty";
       // return linkList.deleteFirst().toString();
    }

    public boolean isEmpty(){
        return linkList.isEmpty();
    }

    public void display(){
        linkList.displayList();
    }
}
