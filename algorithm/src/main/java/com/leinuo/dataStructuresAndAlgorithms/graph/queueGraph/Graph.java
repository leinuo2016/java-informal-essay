package com.leinuo.dataStructuresAndAlgorithms.graph.queueGraph;

import com.leinuo.dataStructuresAndAlgorithms.graph.Vertex;
import com.leinuo.dataStructuresAndAlgorithms.graph.stackGraph.StackX;

/**
 * Create by leinuo on 2020/3/4 下午5:01
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class Graph {
    private final int MAX_VERTS=20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private Queue queue;

    public Graph(){
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts=0;
        for(int j=0;j<MAX_VERTS;j++){
            for(int k=0;k<MAX_VERTS;k++){
                adjMat[j][k]=0;
            }
        }
        queue = new Queue();
    }

    public void addVertex(char lab){
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start,int end){
        adjMat[start][end]=1;
        adjMat[end][start]=1;
    }

    public void displayVertex(int v){
        System.out.print(vertexList[v].label);
    }

    public void bfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.insert(0);
        int v2;
        while (!queue.isEmpty()){
            int v1 = queue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1))!=-1){
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                queue.insert(v2);
            }
        }
    }

    private int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts ; j++) {
            if(adjMat[v][j]==1&&vertexList[j].wasVisited==false)
                return j;
        }
        return -1;
    }
}
