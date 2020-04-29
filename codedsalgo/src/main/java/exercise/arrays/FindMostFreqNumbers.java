package main.java.exercise.arrays;

import java.util.*;

public class FindMostFreqNumbers {

    static List<Integer> solution(List<List<Integer>> l, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < l.size(); i++) {
            List<Integer> l2 = l.get(i);
            for (int j = 0; j < l2.size(); j++) {
                Integer f = map.putIfAbsent(l2.get(j).intValue(), 1);

                if(f != null){
                    map.put(l2.get(j).intValue(), map.get(l2.get(j).intValue())+1);
                    //map.computeIfPresent(l2.get(j).intValue(), (key,val) -> map.put(key.intValue(), ++val));
                }

                //System.out.print(l2.get(j) + ", ");
            }
        }
        map.forEach((key,v) -> System.out.println(key +" - "+v));

        List<Integer> freq = new ArrayList<>();
        freq.addAll(map.values());
        Collections.sort(freq);

        System.out.println(k + " Frequencies: ");
        List<Integer> kfreq = new ArrayList<>();
        for (int i = freq.size()-1; i >(freq.size()-1)-k ; i--) {
            System.out.print(freq.get(i) + ", ");
            kfreq.add(freq.get(i));
        }

        List<Integer> result = new ArrayList<>();
        map.forEach((key, val) -> {
            if(kfreq.contains(val) && result.size()<k){
                result.add(key);
            }
        });

        return result;
    }

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int k = scanner.nextInt();
        scanner.skip("\n");

        List<List<Integer>> list = new ArrayList<>();
        while(scanner.hasNextLine()){
            String n = scanner.nextLine();
            if(n.length()>0) {
                String[] nos = n.split(" ");
                List<Integer> l = new ArrayList<>();
                for (String s : nos) {
                    l.add(Integer.parseInt(s));
                }
                list.add(l);
            } else {
                break;
            }
        }

        List<Integer> res = solution(list, k);
        System.out.println("\nResult: ");
        res.forEach(System.out::println);

    }
}
