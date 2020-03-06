package com.leinuo.dataStructuresAndAlgorithms.graph.queueGraph;


/**
 * Create by leinuo on 2020/3/4 下午5:18
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class BFSApp {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(0,3);
        graph.addEdge(3,4);

        graph.bfs();
    }
}
