package com.leinuo.sort.link;

/**
 * Create by leinuo on 2020/2/21 上午10:19
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 *
 * 先进先出
 */
public class LinkQueue {
    private FirstLastList firstLastList;

    public LinkQueue(){
        firstLastList = new FirstLastList();
    }

    public boolean isEmpty(){
        return firstLastList.isEmpty();
    }

    public void insert(int a,double dd){
        firstLastList.insertLast(a, dd);
    }

    public int remove(){
        if(isEmpty()){
            System.out.println("isEmpty");
            return 0;
        }
        return firstLastList.deleteFirst();
    }

    public void display(){
        firstLastList.disaply();
    }
}
