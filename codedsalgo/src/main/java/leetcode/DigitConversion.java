package main.java.leetcode;

import java.util.*;

public class DigitConversion {
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() < 1) {
            return res;
        }
        Map<String, LinkedList<String>> map = getDigitMap();
        if (digits.length() == 1) {
            LinkedList<String> ca = map.get(digits);
            for (String c : ca) {
                res.add(String.valueOf(c));
            }
            return res;
        }


        System.out.println(map);
        List<LinkedList<String>> cha = createMatchedDigitArray(map, digits);

        res = getCombinations(cha);
        return res;
    }

    private static Map<String, LinkedList<String>> getDigitMap() {
        Map<String, LinkedList<String>> map = new HashMap<>();

        map.put("2", new LinkedList<>(Arrays.asList("a","b","c")));
        map.put("3", new LinkedList<>(Arrays.asList("d","e","f")));
        map.put("4", new LinkedList<>(Arrays.asList("g","h","i")));
        map.put("5", new LinkedList<>(Arrays.asList("j","k","l")));
        map.put("6", new LinkedList<>(Arrays.asList("m","n","o")));
        map.put("7", new LinkedList<>(Arrays.asList("p","q","r","s")));
        map.put("8", new LinkedList<>(Arrays.asList("t","u","v")));
        map.put("9", new LinkedList<>(Arrays.asList("w","x","y","z")));

        return map;
    }

    private static List<LinkedList<String>> createMatchedDigitArray(Map<String, LinkedList<String>> map, String digits) {
        String[] da = digits.split("");
        List<LinkedList<String>> cha = new ArrayList<>();
        int i = 0;
        for (String s : da) {
            cha.add(map.get(s));
        }
        return cha;
    }

    private static void getCombinationsUtil(List<LinkedList<String>> list, Map<Integer, Integer> index, HashSet<String> exists, List<String> res) {
        //System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            //System.out.println(i + "-" + index.get(i));
            if(index.get(i) >= list.get(i).size()){
                return;
            }
            Map<Integer, Integer> indexNew = new HashMap<>(index);
            indexNew.computeIfPresent(i, (k,v)-> ++v);
            getCombinationsUtil(list, indexNew, exists, res);
        }

        String s = "";
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).size()>index.get(i)) {
                s += list.get(i).get(index.get(i));
            }
        }
        if(!exists.contains(s)){
            exists.add(s);
            res.add(s);
            //System.out.println(s);
        }

    }

    private static List<String> getCombinations(List<LinkedList<String>> c1) {
        System.out.println("digit letters: " + c1);
        List<String> res = new ArrayList();
        Map<Integer, Integer> index= new HashMap();
        HashSet<String> exists = new HashSet<>();
        c1.forEach(v-> {
            for (int i = 0; i < c1.size(); i++) {
                index.put(i, 0);
            }
        });
        //System.out.println(index);

        getCombinationsUtil(c1, index, exists, res);
        System.out.println("total combinations: " + res.size());
        System.out.println("combinations: " + res);
        return res;
    }

    public static void main(String[] args) {
        letterCombinations("234");
    }

}
