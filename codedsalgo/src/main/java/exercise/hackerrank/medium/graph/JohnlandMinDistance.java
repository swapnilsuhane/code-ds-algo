package exercise.hackerrank.medium.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class JohnlandMinDistance {

    /*
     * Complete the roadsInHackerland function below.
     */
    static String roadsInHackerland(int n, int[][] roads) {
        int sum = 0;
        LinkedList<Integer[]> roadList = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                Integer[] sa = {i, j};
                roadList.add(sa);
            }
        }

        Map<String, Integer> roapMap = new HashMap<>();

        LinkedList<Integer>[] adjList = new LinkedList[n+1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
        }
        for (int i = 0; i < roads.length; i++) {
            Map<Integer, Integer> map1 = new HashMap<>();
            adjList[roads[i][0]].add(roads[i][1]);
            adjList[roads[i][1]].add(roads[i][0]);

            String key1 = "" + roads[i][0] + roads[i][1];
            String key2 = "" + roads[i][1] + roads[i][0];
            roapMap.put(key1, Double.valueOf(Math.pow(2, roads[i][2])).intValue());
            roapMap.put(key2, Double.valueOf(Math.pow(2, roads[i][2])).intValue());
        }

        //System.out.println(adjList);
        int min = 0;
        while(roadList.peek()!=null){
            Integer[] ia = roadList.pop();

            System.out.println(ia[0] + "-" +ia[1]);

            LinkedList<Integer> list1  = adjList[ia[0]];
            LinkedList<Integer> list2  = adjList[ia[1]];
            min = roapMap.get(ia[0] + "" +ia[1]);
            System.out.println("min: "+min);
            for (Integer i : list1) {
                if(list2.contains(i)){
                    System.out.println("common: "+i);
                    String key1 = ""+ia[0]+i;
                    String key2 = ""+ia[1]+i;

                    //if(roapMap.get(key1)+)
                }
            }
            //System.out.println(adjList[ia[0]].size() + " - " + adjList[ia[1]].size());

        }
        return "";

    }


    public static void main(String[] args) {
        int n = 5;
        int[][] ar = { {1,3,5},{4,5,0},{2,1,3},{3,2,1},{4,3,4},{4,2,2} };
        roadsInHackerland(n, ar);
    }

}
