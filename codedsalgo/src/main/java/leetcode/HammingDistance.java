package main.java.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class HammingDistance {
        public int hammingDistance(int x, int y) {
            List<Boolean> l2 =binary(y, 1);
            List<Boolean> l1 =binary(x, l2.size());

            System.out.println(l1 + "-" + l2);
            int l=0;

            for(int i=0; i<l2.size(); i++){
                if(l2.get(i) !=l1.get(i)){
                    l++;
                }
            }

            return l;
        }

        private List<Boolean> binary(int a, int sz){
            LinkedList<Boolean> l = new LinkedList<>();
            Stack<Boolean> s = new Stack<>();

            while(a!=0){
                System.out.println(a);
                s.push(a%2!=0);
                a = a/2;

            }
            while(!s.isEmpty()){
                l.add(s.pop());
                sz--;
            }

            while(--sz>=0){
                l.addFirst(false);
            }


            return l;
        }

    public static void main(String[] args) {
        HammingDistance hammingDistance = new HammingDistance();
        System.out.println("hamming distance: " +hammingDistance.hammingDistance(1, (int) Math.pow(2, 31)));
    }
}
