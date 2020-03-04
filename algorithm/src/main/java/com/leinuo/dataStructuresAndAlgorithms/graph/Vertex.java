package com.leinuo.dataStructuresAndAlgorithms.graph;

/**
 * Create by leinuo on 2020/3/4 下午4:40
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char lab){
        label = lab;
        wasVisited = false;
    }
}
