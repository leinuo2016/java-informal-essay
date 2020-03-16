package com.leinuo.dataStructuresAndAlgorithms.graphw;

import sun.security.x509.EDIPartyName;

/**
 * Create by leinuo on 2020/3/6 上午10:45
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class PriorityQ {
    private final int SIZE = 20;
    private Edge[] queArray;
    private int size;

    public PriorityQ(){
        queArray = new Edge[SIZE];
        size=0;
    }

    public void insert(Edge item){
        int j;
        for(j=0;j<size;j++)
            if(item.distance>=queArray[j].distance)
                break;

        for (int k = size-1;k>=j;k--)
            queArray[k+1] = queArray[k];

        queArray[j] = item;
        size++;
    }

    public Edge removeMin(){
        return queArray[--size];
    }

    public void removeN(int n){
        for (int i = n; i <size-1 ; i++)
            queArray[i] = queArray[i+1];
        size--;
    }

    public Edge peekMin(){
        return queArray[size-1];
    }

    public Edge peekN(int n){
        return queArray[n];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int find(int findDex){
        for (int j = 0; j < size; j++)
            if(queArray[j].destVert==findDex)
                return j;
        return -1;
    }

}
