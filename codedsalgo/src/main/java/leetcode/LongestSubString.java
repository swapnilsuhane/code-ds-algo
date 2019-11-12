package main.java.leetcode;

import java.util.*;

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

    public int lengthOfLongestSubstring2(String s) {
        if(s==null || "".equals(s)){
            return 0;
        }

        String[] sa = s.split("");
        int max = 0;
        HashMap<String, List<Integer>> index = new HashMap();

        for(int i=0; i<sa.length; i++){
            if(index.containsKey(sa[i])){
                List<Integer> idx = new ArrayList();
                idx.addAll(index.get(sa[i]));
                idx.add(i);
                index.put(sa[i], idx);
            } else{
                List<Integer> list = Arrays.asList(i);
                index.put(sa[i], list);
            }
        }
        // System.out.println(index);
        for(int i=0; i<sa.length; i++){
            List<Integer> list = index.get(sa[i]);
            final int c = i;
            Optional<Integer> opt = list.stream().filter(l -> l>c).findFirst();
            int p = opt.isPresent() ? opt.get(): s.length();
            String sub = s.substring(i+1, p);
            //System.out.println("sub: " + sub);
            int m = findMaxLength(sub);
            max = m>max ? m : max;
        }
        return max;
    }

    private int findMaxLength(String s){
        HashSet<String> set = new HashSet();
        int max = 0;
        String[] sa = s.split("");
        for(int i=0; i<sa.length; i++){
            if(set.contains(sa[i])){
                return max;
            } else{
                set.add(sa[i]);
            }
            max = set.size() > max? set.size(): max;
        }
        return max;
    }

    //Sliding window
    public int lengthOfLongestSubstring3(String s) {
        if(s==null || "".equals(s)){
            return 0;
        }

        int i=0, j=0, max=0;
        HashSet<Character> set = new HashSet();
        while(i<s.length() && j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else{
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
}
