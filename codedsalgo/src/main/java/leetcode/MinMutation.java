package main.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinMutation {

    public static int minMutation(String start, String end, String[] bank) {
        char[] st = start.toCharArray();
        char[] ed = end.toCharArray();
        int mut = 0;
        Map<String, String> map = new HashMap<>();
        for (String b : bank) {
            map.put(b, "");
        }
        for (int i = 0; i < start.length(); i++) {
            if(st.toString().equals(ed.toString())){
                return mut;
            }

            if (st[i]!=ed[i]){
                System.out.println(st[i] + "-"+ed[i]);
                st[i] = ed[i];

                System.out.println(String.valueOf(st));
                if(!map.containsKey(String.valueOf(st))){
                    return -1;
                }else{
                    mut++;
                }
            }
        }

        return mut++;
    }


    public static void main(String[] args) {
        String[] sa = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        int i =minMutation("AACCGGTT", "AAACGGTA", sa);
        System.out.println(i);
    }
}
