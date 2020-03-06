package com.leinuo.dataStructuresAndAlgorithms.graph.queueGraph;

import java.util.logging.SimpleFormatter;

/**
 * Create by leinuo on 2020/3/5 下午2:37
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class Queue {
    private final int SIZE = 20;
    private int[] que;
    private int front;
    private int rear;

    public Queue() {
        que = new int[SIZE];
        front = 0;
        this.rear = -1;
    }

    public void insert(int j){
        if (rear== SIZE-1)
            rear = -1;
        que[++rear] = j;
    }

    public int remove(){
        int temp = que[front++];
        if (front==SIZE)
            front=0;
        return temp;
    }

    public boolean isEmpty(){
        return (rear+1==front||(front+SIZE-1==rear));
    }
}
