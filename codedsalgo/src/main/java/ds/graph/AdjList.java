package ds.graph;

import java.util.LinkedList;

public class AdjList {
    static LinkedList<Integer>[] lists;

    static void initList(String[] sa, int v){
        lists = new LinkedList[v];

        //init linked list
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new LinkedList<>();
        }

        for (String s: sa) {
            int x=Integer.valueOf(s.substring(0,1));
            int y=Integer.valueOf(s.substring(1));
            lists[x].add(y);
            lists[y].add(x);
        }
    }

    static void print(){
        System.out.println("Adjacency List");
        for (LinkedList<Integer> list: lists) {
            for (Integer i: list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        String[] sa = {"01", "04", "14", "13", "12", "32", "34"};
        int noOfVertices = 5;
        initList(sa, noOfVertices);
        print();
    }
}
