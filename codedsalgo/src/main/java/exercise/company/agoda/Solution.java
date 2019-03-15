package exercise.company.agoda;

import java.util.*;

public class Solution {

    public static List<Integer> connectedCities(int n, int g, List<Integer> originCities, List<Integer> destinationCities) {
        List<Integer> r = new ArrayList<>(originCities.size());
        Map<Integer, TreeSet<Integer>> divCityMap = new HashMap();
        Map<Integer, TreeSet<Integer>> cityDivMap = new HashMap();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(j%i==0) {
                    if (!divCityMap.containsKey(i)) {
                        TreeSet<Integer> s = new TreeSet<>();
                        s.add(j);
                        divCityMap.put(i, s);
                    } else {
                        TreeSet<Integer> s  =divCityMap.get(i);
                        s.add(j);
                        divCityMap.put(i, s);
                    }

                    if (!cityDivMap.containsKey(j)) {
                        TreeSet<Integer> s = new TreeSet<>();
                        s.add(i);
                        cityDivMap.put(j, s);
                    } else {
                        TreeSet<Integer> s  =cityDivMap.get(j);
                        s.add(i);
                        cityDivMap.put(j, s);
                    }

                }
            }
        }

        cityDivMap.forEach((k, v) -> {
            System.out.println("City: " + k + " Div - " + v);
        });

        divCityMap.forEach((k, v) -> {
            System.out.println("Div: " + k + " City- " + v);
        });

        //adjacency list
        Map<Integer, List<Integer>> gr = new HashMap<>();
        Set<Integer> disConn = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            TreeSet<Integer> set = cityDivMap.get(i);
            //System.out.println("max div: " + set.last());
            if(set.last()>g){
                List<Integer> l = new LinkedList<>();
                for (Integer div: set) {
                    //System.out.println(i + " divs : " +div);
                    if(!disConn.contains(div)){
                        TreeSet<Integer> cities = divCityMap.get(div);
                        for (Integer c: cities) {
                            //System.out.println(i + " divs : " +div + " c : " + c);
                            if(c!=i){
                                l.add(c);
                            }
                        }
                    }
                }
                if(!gr.containsKey(i)) {
                    gr.put(i, l);
                } else{
                    List<Integer> list = gr.get(i);
                    list.addAll(l);
                    gr.put(i, list);
                }
            } else{
                disConn.add(i);
                gr.put(i, new LinkedList<>());
            }
        }

        System.out.println("adj list: ");
        gr.forEach((k,v) -> System.out.println(k +" - "+v));

        //check city is connected or not
        for (int i = 0; i < originCities.size(); i++) {
            int s = originCities.get(i);
            int d = destinationCities.get(i);

            if(disConn.contains(s) || disConn.contains(d)){
                r.add(0);
                continue;
            }

            if(isCityConnected(gr, s, d)) {
                r.add(1);
            } else {
                r.add(0);
            }
        }
        return r;
    }

    private static boolean isCityConnected(Map<Integer, List<Integer>> gr, Integer s, Integer d){
        LinkedList<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.add(s);
        visited.add(s);
        //System.out.println("queue : "+queue.peek());

        while (queue.peek()!=null){
            Integer c = queue.poll();
            List<Integer> l = gr.get(c);

            for (Integer i: l) {
                if(!visited.contains(i)) {
                    queue.add(i);
                    visited.add(i);
                }

            }
        }

        System.out.println("SourceCity: " +s + " DestCity: "+d + "visited: " +visited);

        if(visited.contains(d)){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(4);
        l1.add(6);
        l1.add(3);

        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(3);
        l2.add(3);
        l2.add(4);
        l2.add(4);

        System.out.println("Result: ");
        connectedCities(6, 2, l1, l2).forEach(System.out::println);
    }
}
