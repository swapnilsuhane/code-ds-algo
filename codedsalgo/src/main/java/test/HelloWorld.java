package main.java.test;

import java.util.*;

public class HelloWorld {

    public static void main(String[] args) {
        HelloWorld h = new HelloWorld();

        System.out.println((8>>2));
        String s = 'C'+"";
        System.out.println(s);
        char[] ca = {'C'};
        System.out.println(String.valueOf(ca));


        System.out.println("");
    }

    private static Integer hash(String s) {
        if (s == null) {
            return 0;
        }
        Map<Character, Integer> freq = new HashMap();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        Integer h = 1;
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            h *= (entry.getKey().hashCode() * 31 * entry.getValue()) % 1000000;
        }
        return h;

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr) {{
                    add(num);
                }});
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }


}

