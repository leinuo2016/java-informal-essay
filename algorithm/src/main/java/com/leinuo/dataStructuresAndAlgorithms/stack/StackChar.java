package com.leinuo.dataStructuresAndAlgorithms.stack;

/**
 * Create by leinuo on 2020/2/7 下午3:56
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class StackChar {

    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackChar(int size){
        this.maxSize=size;
        this.stackArray = new char[size];
        this.top=-1;
    }

    public void push(char value){
        stackArray[++top]=value;
    }

    public char pop(){
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
