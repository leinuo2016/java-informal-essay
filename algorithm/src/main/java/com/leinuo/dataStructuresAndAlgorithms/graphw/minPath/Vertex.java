package com.leinuo.dataStructuresAndAlgorithms.graphw.minPath;

/**
 * Create by leinuo on 2020/3/16 下午4:52
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class Vertex {
    public char label;
    public boolean isInTree;

    public Vertex(char lab){
        label = lab;
        isInTree = false;
    }
}
