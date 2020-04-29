package main.java.exercise.hackerrank.medium.graph;

import java.util.*;

public class Matrix {

    // Complete the minTime function below.
    private static int minTime(Map<Integer, Map<Integer, Integer>> graph, int s, int d) {
        //System.out.println("minTime: " + s + "," + d);
        int min = Integer.MAX_VALUE;
        int[] minAr = new int[3];
        boolean found = false;
        LinkedList<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>(graph.size());

        queue.add(s);
        visited.add(s);

        while (queue != null && queue.peek() != null) {
            int i = queue.poll();
            Map<Integer, Integer> map = graph.get(i);
            if(map!=null){
                for (Integer key : map.keySet()) {
                    if (!visited.contains(key)) {
                        queue.add(key);
                        visited.add(key);

                        if (min > map.get(key)) {
                            min = map.get(key);
                            minAr[0] = i;
                            minAr[1] = key;
                            minAr[2] = min;

                            //System.out.println( "minAr inside: " + minAr[0] + "-"+ minAr[1] + "-" +minAr[2]);
                        }

                        if (key == d) {
                            found = true;
                            queue = null;
                            break;

                        }
                    }
                }
            }
        }
        if (found) {
            //System.out.println("minAr: " + minAr[0] + "-" + minAr[1] + "-" + minAr[2]);
            Map<Integer, Integer> map1 = graph.get(minAr[0]);
            map1.remove(minAr[1]);
            graph.put(minAr[0], map1);
            Map<Integer, Integer> map2 = graph.get(minAr[1]);
            map2.remove(minAr[0]);
            graph.put(minAr[1], map2);
            System.out.println("min : " + min);

            min = (min == Integer.MAX_VALUE) ? 0 : min;
        } else {
            System.out.println("no connection");
            min = 0;
        }
        return min;
    }

    static int minTime(int[][] roads, int[] machines) {
        int time = 0;
        List<int[]> mList = new ArrayList<>();
        for (int i = 0; i < machines.length; i++) {
            for (int j = i + 1; j < machines.length; j++) {
                int[] ints = {machines[i], machines[j]};
                mList.add(ints);
            }
        }
        // mList.forEach(r -> System.out.println(r[0] + "-" +r[1]));

        //road sour, dest, wt
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] road : roads) {
            Map<Integer, Integer> newValue = new HashMap<>();
            newValue.put(road[1], road[2]);
            Map<Integer, Integer> curVal = graph.putIfAbsent(road[0], newValue);

            if (curVal != null) {
                curVal.put(road[1], road[2]);
                graph.put(road[0], curVal);
            }

            newValue = new HashMap<>();
            newValue.put(road[0], road[2]);
            curVal = graph.putIfAbsent(road[1], newValue);

            if (curVal != null) {
                curVal.put(road[0], road[2]);
                graph.put(road[1], curVal);
            }
        }

        System.out.println("graph: ");
        graph.forEach((k,v) -> {
            System.out.println(k + " - " + v);
        });


        for (int[] m : mList) {
            int st = m[0];
            int ed = m[1];

            time = time + minTime(graph, st, ed);
//            System.out.println("graph later: ");
//            graph.forEach((k, v) -> {
//                System.out.println(k + " - " + v);
//            });

        }


        return time;
    }

    public static void main(String[] args) {
//        5 3
//        2 1 8
//        1 0 5
//        2 4 5
//        1 3 4
//        2
//        4
//        0

//        5,4
//        0 3 3
//        1 4 4
//        1 3 4
//        0 2 5
//        1
//        3
//        4
        //int[][] roads = {{2,1,8},{1,0,5},{2,4,5},{1,3,4}}; int[] machines = {2,4,0};

        //int[][] roads = {{0, 3, 3}, {1, 4, 4}, {1, 3, 4}, {0, 2, 5}};
        int[][] roads = {{9,78,35},{9,54,45},{78,69,27},{9,55,9},{9,1,78},{1,92,7},{55,42,57},{1,84,4},{1,5,38},{92,8,75},{55,30,99},{69,7,9},{1,81,45},{8,31,4},{42,23,100},{78,95,3},{54,14,14},{84,53,80},{92,32,8},{42,86,40},{1,64,93},{78,60,65},{64,76,24},{42,89,86},{7,28,48},{69,62,26},{1,40,23},{78,38,29},{8,44,39},{78,3,37},{54,26,17},{62,50,24},{76,66,37},{30,51,75},{86,43,91},{5,77,32},{64,91,11},{14,10,36},{26,20,19},{9,52,50},{77,94,32},{44,67,63},{64,15,61},{92,0,73},{10,37,23},{89,2,37},{92,18,51},{26,47,25},{30,87,15},{47,36,35},{92,72,16},{28,75,93},{78,73,66},{20,19,64},{73,57,1},{91,6,50},{54,33,41},{78,11,38},{37,71,55},{5,63,52},{10,46,22},{94,82,19},{95,83,51},{57,90,10},{63,58,94},{43,45,23},{72,68,62},{82,85,88},{58,4,94},{82,41,62},{3,22,68},{54,70,78},{31,74,27},{36,29,61},{33,24,76},{40,35,61},{83,79,51},{8,59,20},{45,34,26},{38,12,18},{70,99,25},{40,80,81},{31,97,58},{69,21,16},{83,13,22},{80,48,49},{97,65,44},{74,17,1},{68,16,92},{50,98,54},{94,27,76},{81,61,67},{85,49,96},{81,93,31},{22,25,67},{57,96,93},{82,88,92},{86,56,80},{25,39,44}};
        int[] machines = {1,95,90,11,48,49,23,6,0,76,3,83,85,31,44,54,87,38,16,61,22,21,29};
        System.out.println("Result: " + minTime(roads, machines));
    }
}
