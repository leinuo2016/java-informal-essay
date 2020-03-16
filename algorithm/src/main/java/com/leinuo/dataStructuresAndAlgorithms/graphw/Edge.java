package com.leinuo.dataStructuresAndAlgorithms.graphw;

/**
 * Create by leinuo on 2020/3/6 上午10:44
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class Edge {
    public int srcVert;
    public int destVert;
    public int distance;

    public Edge(int srcVert, int destVert, int distance) {
        this.srcVert = srcVert;
        this.destVert = destVert;
        this.distance = distance;
    }
}
