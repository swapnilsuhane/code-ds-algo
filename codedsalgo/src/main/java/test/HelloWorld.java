package main.java.test;

import java.util.*;
import java.util.stream.Collectors;

public class HelloWorld {

    private static int[] getIndexes(int[] idx, int max, int cur, int...var){
        for (int v: var) {
            if(v == max){
                return idx;
            }
            return getIndexes(idx, max, cur, v, v++);
            //System.out.println(v);
        }


        for(int i=0; i<idx.length; i++){
            cur = Math.max(cur, idx[i]++);
            System.out.println(idx[i] + " cur :" + cur);
            return getIndexes(idx, max, cur);
        }
        return idx;
    }

    public static void main(String[] args) {
        getIndexes(new int[]{0,0}, 3, 0, 0,0);

//        HashMap<Integer, List> map=new HashMap<>();
//
//        List<Character> l=new ArrayList<>();
//        Optional<Integer> opt;
//        l.stream().collect(Collectors.toList());
//        System.out.println((char)97);
//        Set<String> set;
//        Stack s;
//        map.computeIfPresent(1, (k,v) -> {
//            System.out.println(k);
//                    return v;
//        }
//        );
//        LinkedList<Integer> ll = new LinkedList<>();
//
//
//        Set<Integer> fl = new HashSet();

    }


}

