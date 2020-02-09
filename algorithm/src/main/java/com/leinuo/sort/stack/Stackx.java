package com.leinuo.sort.stack;

import javax.swing.plaf.SpinnerUI;

/**
 * Create by leinuo on 2020/2/7 下午3:56
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class Stackx {

    private int maxSize;
    private long[] stackArray;
    private int top;

    public Stackx(int size){
        this.maxSize=size;
        this.stackArray = new long[size];
        this.top=-1;
    }

    public void push(long value){
        stackArray[++top]=value;
    }

    public long pop(){
        return stackArray[top--];
    }

    public long peek(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return this.top==-1?true:false;
    }

    public boolean isFull(){
        return this.top==maxSize-1?true:false;
    }
}
