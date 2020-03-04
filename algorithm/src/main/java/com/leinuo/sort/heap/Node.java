package com.leinuo.sort.heap;

/**
 * Create by leinuo on 2020/3/3 下午5:17
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class Node {

    private int iData;

    public Node(int key){
        iData = key;
    }

    public int getKey(){
        return iData;
    }

    public void setKey(int id){
         iData = id;
    }

}
