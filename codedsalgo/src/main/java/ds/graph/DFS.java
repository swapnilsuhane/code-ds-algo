package main.java.ds.graph;

import java.util.LinkedList;
import java.util.Stack;

public class DFS {

    private static void printDFS(Graph graph, int i) {
        boolean[] visited = new boolean[graph.edges.length];
        visited[i-1]=true;
        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        while (!stack.isEmpty()){
            int v = stack.pop();
            System.out.print(v +", ");
            LinkedList<Integer> linkedList = graph.edges[v-1];
            for (Integer n : linkedList) {
               if(!visited[n-1]){
                   visited[n-1] = true;
                   stack.push(n);
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

        System.out.println("Depth First Traversal (DFS): ");
        printDFS(graph, 1);

    }
}
