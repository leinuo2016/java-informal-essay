package com.leinuo.dataStructuresAndAlgorithms.graph.stackGraph;

/**
 * Create by leinuo on 2020/3/4 下午4:41
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class StackX {
    private final int SIZE = 20;
    private int[] st;
    private int top;

    public StackX(){
        st = new int[SIZE];
        top = -1;
    }

    public void push(int j){
        st[++top] = j;
    }

    public int pop(){
        return st[top--];
    }

    public int peek(){
        return st[top];
    }
    public boolean isEmpty(){
        return top==-1;
    }

}
