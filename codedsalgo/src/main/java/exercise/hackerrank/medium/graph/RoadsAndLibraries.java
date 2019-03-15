package exercise.hackerrank.medium.graph;

import java.util.*;

public class RoadsAndLibraries {

    // Complete the roadsAndLibraries function below.
    static long solution(int n, int c_lib, int c_road, int[][] cities) {
        long c = 0;
        Boolean[] visited = new Boolean[n];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        LinkedList<Integer> queue = new LinkedList<>();

        //lib cost is low
        if(c_lib<=c_road || cities.length==0){
            c = Long.valueOf(n) * Long.valueOf(c_lib);;
        } else {
            //adjacency list
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int[] city : cities) {
                //System.out.println(city[0] + "-" + city[1]);
                if (!map.containsKey(city[0])) {
                    List value = new LinkedList();
                    value.add(city[1]);
                    map.put(city[0], value);
                } else {
                    List value = map.get(city[0]);
                    value.add(city[1]);
                    map.put(city[0], value);
                }

                if (!map.containsKey(city[1])) {
                    List value = new LinkedList();
                    value.add(city[0]);
                    map.put(city[1], value);
                } else {
                    List value = map.get(city[1]);
                    value.add(city[0]);
                    map.put(city[1], value);
                }
            }
            //System.out.println(map);

            //init
            queue.add(cities[0][0]);
            visited[cities[0][0]-1]=true;

            long count = n;
            long roads = 0;
            while (queue.peek()!=null || count>1){
                List<Integer> set = map.get(queue.poll());
                //System.out.println("count: " +count + "-" +set);
                if(set !=null) {
                    for (Integer i : set) {
                        //System.out.println(visited[i - 1]);
                        if (!visited[i - 1]) {
                            roads++;
                            count--;
                            queue.add(i);
                            visited[i - 1] = true;
                        }
                    }
                }

                if(queue.peek()==null){
                    c= c + (c_lib + c_road*roads);
                    //System.out.println("cost: " +c);
                    roads = 0;

                    for (int i = 0; i < visited.length; i++) {

                        if(!visited[i]){
                            //System.out.println("not visited yet"+ i);
                            set = map.get(i+1);
                            count--;
                            visited[i] = true;
                            if(set ==null){
                                c= c + (c_lib + c_road*roads);
                                roads = 0;
                            } else {
                                queue.add(i+1);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
//        3 3 2 1
//        1 2
//        3 1
//        2 3

//        6 6 2 5
//        1 3
//        3 4
//        2 4
//        1 2
//        2 3
//        5 6

//        5 3 6 1
//        1 2
//        1 3
//        1 4
        int city = 6;
        int c_l = 5, c_r = 1;
       // int[][] cities = {{1,2},{3,1},{2,3}};
        //int[][] cities = {{1, 3},{3, 4},{2, 4},{1, 2},{2, 3},{5, 6}};
        int[][] cities = {{1,2},{1,3},{1,4},{5,6}};

        long r = solution(city, c_l, c_r, cities);

        System.out.println(r);

    }
}
