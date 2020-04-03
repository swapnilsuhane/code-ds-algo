package main.java.leetcode;

import java.time.Instant;
import java.util.*;

public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        Instant now = Instant.now();
        System.out.println(uniquePaths.uniquePaths(4, 4));
        System.out.println("Time: " + (Instant.now().getEpochSecond() - now.getEpochSecond()));
    }

    //m=column, n=rows
    public int uniquePaths(int m, int n) {
        //System.out.println(m + " - "+n);

        Map<String, List<String>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                List<String> l = new ArrayList<>();
                String r = getRight(i, j, n - 1);
                String d = getDown(i, j, m - 1);
                if (r != null) {
                    l.add(r);
                }
                if (d != null) {
                    l.add(d);
                }
                graph.put("" + i + j, l);
            }
        }
        System.out.println(graph);
        int p = findPaths(graph, "00", "" + (n - 1) + (m - 1));
        return p;
    }

    //get right coordinates
    private String getRight(int i, int j, int k) {
        if ((i + 1) <= k) {
            return "" + (i + 1) + j;
        } else {
            return null;
        }
    }

    //get down coordinates
    private String getDown(int i, int j, int k) {
        if ((j + 1) <= k) {
            return "" + i + (j + 1);
        } else {
            return null;
        }
    }

    private int findPaths(Map<String, List<String>> graph, String o, String d) {
        List<String> nodes = graph.get(o);
        //Stack<String> st = new Stack();
        Stack<String> tempS = new Stack<>();
        Set<String> visited = new HashSet();
        //st.add(o);
        tempS.add(o);
        visited.add(o);
        int count = 0;

        while (!tempS.isEmpty()) {
            String s = tempS.pop();
            //System.out.println("s: " +s);
            if (s.equals(d)) {
                count++;
            }

            List<String> l = graph.get(s);
            for (String nd : l) {
                if (!visited.contains(nd)) {
                    // st.add(nd);
                    tempS.add(nd);
                }
            }
        }

        //System.out.println("st: " +st);
        return count;
    }
}

