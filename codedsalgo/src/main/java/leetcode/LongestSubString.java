package main.java.leetcode;

import java.util.HashSet;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || "".equals(s)){
            return 0;
        }

        String[] sa = s.split("");
        int max = 0;
        int c = 0;
        HashSet<String> set = new HashSet();
        for(int i=0; i<sa.length; i++){
            for(int j=i; j<sa.length; j++){
                String str = sa[j];
                //System.out.println("str: "+str);
                if(!set.contains(str)){
                    set.add(str);
                    c++;
                    max = c > max? c: max;
                    //System.out.println("max: "+max);
                } else{
                    //System.out.println("else: ");
                    set = new HashSet();
                    set.add(str);
                    c = 1;
                }
            }
            set = new HashSet();
            c=0;
        }
        return max;
    }
}
