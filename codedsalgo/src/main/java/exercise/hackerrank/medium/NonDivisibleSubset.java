package main.java.exercise.hackerrank.medium;

import java.util.ArrayList;
import java.util.List;

//TODO
public class NonDivisibleSubset {

    static List<List<Integer>> combination(int[] S, List<List<Integer>> lists){
        List<List<Integer>> combList = new ArrayList<>();
        if(lists.size()==0){
            return combList;
        }

        return combList;

    }

    // Complete the nonDivisibleSubset function below.
    static int nonDivisibleSubset(int k, int[] S) {

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < S.length; i++) {
            for (int j = i; j < S.length; j++) {
                if ((S[i] + S[j]) % k == 0) {
                    List<Integer> l = new ArrayList<>();
                    l.add(S[i]);
                    l.add(S[j]);
                    lists.add(l);
                }
            }
        }



        lists.stream().forEach(System.out::println);
        return 3;
    }

    public static void main(String[] args) {
        int[] ints = {1, 7, 2, 4};
        nonDivisibleSubset(3, ints);
    }
}
