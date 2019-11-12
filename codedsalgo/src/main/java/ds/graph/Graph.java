package main.java.ds.graph;

import java.util.LinkedList;

public class Graph {
    int v;

    LinkedList<Integer>[] edges;

    public Graph(int v) {
        this.v = v;

        edges = new LinkedList[v];

        for (int i = 0; i < edges.length; i++) {
            edges[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest){
        edges[src-1].add(dest);
        edges[dest-1].add(src);
    }

    public void print(){
        for (LinkedList<Integer> edge: edges) {
            for(Integer e : edge){
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
