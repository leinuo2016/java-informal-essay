package com.leinuo.dataStructuresAndAlgorithms.queue;

/**
 * Create by leinuo on 2020/2/9 上午9:33
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class Queue {

    private int maxSize;

    private long[] queArray;

    private int front;

    private int rear;

    private int nItems;

    public Queue(int size){
        this.maxSize=size;
        this.queArray = new long[size];
        this.front=0;
        this.rear=-1;
        this.nItems=0;
    }

    public void insert(long value){
        if(isFull()){
            System.out.println("queue is full!");
            return;
        }
        queArray[++rear]=value;
        nItems++;
    }

    public long remove(){
        long temp = queArray[front++];
        if(front==maxSize)
            front=0;
        nItems--;
        return temp;
    }

    public long peekFront(){
        return queArray[front];
    }

    public boolean isEmpty(){
        return nItems==0;
    }

    public boolean isFull(){
        return nItems==maxSize;
    }

    public int size(){
        return nItems;
    }
}
