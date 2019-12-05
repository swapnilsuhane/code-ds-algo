package main.java.exercise;

import java.util.Stack;

public class Combinations {

    private static Stack<Stack<Integer>> makeCombiUtil(Stack<Stack<Integer>> stack, Stack<Integer> temp,
                                                       int n, int left, int k) {
        if(k==0){
            stack.push(temp);
            return stack;
        }

        for (int i = left; i <= n; i++) {
            System.out.println("i :  " +i);
            temp.push(i);

            makeCombiUtil(stack, temp, n, i+1, k-1);
            // temp.po
        }
        return stack;
    }

    private static Stack<Stack<Integer>> makeCombi(int n, int k) {
        Stack<Stack<Integer>> stack = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        stack = makeCombiUtil(stack, temp, n, 1, k);
        return stack;
    }


    public static void main(String[] args) {
        int n = 5;
        int k = 3;

        Stack<Stack<Integer>> com = makeCombi(n, k);
        System.out.println("result size: " +com.size());
        System.out.println(com);
        com.stream().forEach(s -> {
            s.stream().forEach(v -> System.out.print(v + " "));
            System.out.println();
        });

    }
}
