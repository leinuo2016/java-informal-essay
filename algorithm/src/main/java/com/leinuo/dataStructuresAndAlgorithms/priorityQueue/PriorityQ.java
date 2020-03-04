package com.leinuo.dataStructuresAndAlgorithms.priorityQueue;

/**
 * Create by leinuo on 2020/2/9 下午8:08
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class PriorityQ {

    private int maxSize;

    private long[] queArray;

    private int nItems;

    public PriorityQ(int size){
        this.maxSize = size;
        queArray = new long[maxSize];
        nItems = 0;
    }

    public void insert(long value){
        if(isFull()){
            System.out.println("isFull!");
            return;
        }
        int j;
        if(nItems==0){
            queArray[nItems++] = value;
        }else {
            for(j=nItems-1;j>=0;j--){
                if(value>queArray[j]){
                    queArray[j+1] = queArray[j];
                }else {
                    break;
                }
            }
            queArray[j+1] = value;
            nItems++;
        }
    }
    public long remove(){
        return queArray[--nItems];
    }
    public long peekMin(){
        return queArray[nItems-1];
    }
    public boolean isEmpty(){
        return nItems==0;
    }
    public boolean isFull(){
        return nItems==maxSize;
    }
}
