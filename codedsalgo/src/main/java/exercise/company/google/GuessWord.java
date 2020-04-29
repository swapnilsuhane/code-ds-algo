package main.java.exercise.company.google;

import java.util.*;

public class GuessWord {

    //guessApi API
    public static String guessApi(String s){
        String word = "lec";
        if(s.equals(word)){
            return s;
        }
        String res = "";
        String[] s1 = word.split("");
        String[] s2 = s.split("");

        for (int i = 0; i < s.length(); i++) {
            if(s1[i].equals(s2[i])){
                res = res + s1[i];
            } else{
                res = res + "-";
            }
        }
        return res;
    }

    private static String guessWord(List<String> words){
        Map<String, Map<String, List<String>>> map = new HashMap<>();
        for (String s: words) {
            String[] sa = s.split("");
            for (int i = 0; i < sa.length; i++) {
                String key = i + sa[i];
                Map<String, List<String>> value = new HashMap<>();
                value.put(key, Arrays.asList(s));
                if(map.containsKey(key)){
                    Map<String, List<String>> newValue = map.get(key);
                    List<String> list = new ArrayList<>(newValue.get(key));
                    list.add(s);
                    newValue.put(key, list);
                    map.put(key, newValue);
                } else {
                    map.put(key, value);
                }
            }
        }

        System.out.println(map);

        return "";
    }


    public static void main(String[] args) {
        List<String> words = Arrays.asList("abc", "def", "tie", "lec", "dec", "ace");
        System.out.println(guessApi("dec"));
        //System.out.println("abc".substring(2));

        guessWord(words);
    }
}
