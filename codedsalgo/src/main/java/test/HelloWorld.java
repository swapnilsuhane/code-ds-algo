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

    private static String swap(String base, int i, int j){
        return base.substring(0, i) + base.substring(j, j+1)+ base.substring(i+1, j)+
        base.substring(i, i+1) + base.substring(j+1);
    }

    public static void main(String[] args) {
       // getIndexes(new int[]{0,0}, 3, 0, 0,0);
        System.out.println("North".hashCode());
        System.out.println("NORTH".hashCode());
        List<String>[] lists = new ArrayList[5];
        List<String> s = new ArrayList<>();
        s.stream().distinct().collect(Collectors.toList());
        s.add("fds");
        lists[0]=s;
        lists[1]=s;

        //lists[1]= Arrays.asList("4");
        System.out.println(lists[1]);

        System.out.println("how".substring(0, 0+1));
        Map<String, String> map = new HashMap();
        System.out.println("((()))".replace("((()))".charAt(1), "((()))".charAt(3)));
        String b = "((()))";

        System.out.println(swap(b, 2, 4));
    int i = 0;
        System.out.println(i+=2);
        System.out.println(i+=2);





//        HashMap<Integer, List> map=new HashMap<>();
//
//        List<Character> l=new ArrayList<>();
//        Optional<Integer> opt;
//        l.stream().collect(Collectors.toList());
//        System.out.println((char)97);



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

