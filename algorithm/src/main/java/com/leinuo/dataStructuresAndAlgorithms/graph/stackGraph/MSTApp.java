package com.leinuo.dataStructuresAndAlgorithms.graph.stackGraph;

/**
 * Create by leinuo on 2020/3/5 下午2:57
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class MSTApp {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(0,4);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        graph.addEdge(3,4);
        graph.mst();
    }
}
