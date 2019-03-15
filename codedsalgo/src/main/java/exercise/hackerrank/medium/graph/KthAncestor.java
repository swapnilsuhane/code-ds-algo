package exercise.hackerrank.medium.graph;

import java.util.HashMap;
import java.util.Map;

public class KthAncestor {

    /*
     * Complete the roadsInHackerland function below.
     */
    static void solution(int[][] tree, int[][] query) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t: tree){
            map.put(t[0], t[1]);
        }

        //System.out.println(map);

        for (int[] q: query) {

            //System.out.println("query: " +q[0] + "-"+q[1]);
            //add
            if(q[0]==0){
                map.put(q[2], q[1]);
            //remove
            } else if(q[0]==1){
                map.remove(q[1]);
            //query
            } else if(q[0]==2){
                int count = q[2];
                Integer key = q[1];
                while(count>0 && key!=-1){
                    count--;
                    key = map.get(key)==null ?-1 : map.get(key);
                }

                System.out.println(key==-1 ?0 : key);
            }
        }

    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int[][] tree = {{2,0},{5,2},{3,5},{7,5},{9,8},{8,2},{6,8}};
        int[][] query = {{0,5,15},{2,15,2},{1,3},{0,15,20},{0,20,13},{2,13,4},{2,13,3},{2,6,10},{2,11,1},{2,9,1}};

        solution(tree, query);
    }

}
