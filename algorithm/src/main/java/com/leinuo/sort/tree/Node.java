package com.leinuo.sort.tree;

/**
 * Create by leinuo on 2020/2/28 上午11:03
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class Node {
    public int iData;
    public double dData;
    public Node leftNode;
    public Node rightNode;

    public void displayNode(){
        System.out.println(String.format("{iData:%d,dData:%d}",iData,dData));
    }
}
