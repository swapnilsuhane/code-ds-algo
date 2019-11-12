package main.java.ds.graph;

import java.util.LinkedList;

public class BFS {

    public static void printBFS(Graph graph, int v){
        boolean[] visited = new boolean[graph.v];
        visited[v-1]=true;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(v);

        while(queue.peek()!=null){
            int i = queue.pop();
            System.out.print(i +", ");

            LinkedList<Integer> edge = graph.edges[i - 1];
            //System.out.println("edge: "+edge);
            for (Integer e: edge) {
                if(!visited[e-1]) {
                    queue.add(e);
                    visited[e-1]=true;
                }
            }


        }

    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(2,5);
        graph.addEdge(3,5);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,6);

        System.out.println("Adjacency List: ");
        graph.print();

        System.out.println("Breath First Traversal (BFS): ");
        printBFS(graph, 1);
    }
}
