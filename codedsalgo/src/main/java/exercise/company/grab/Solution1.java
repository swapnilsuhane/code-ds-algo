package main.java.exercise.company.grab;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    private static int convert(int[] A){
        int t=0;
        for(int i=0; i<A.length; i++){
            if(A[i]==0){
                continue;
            }
            int p = (int) Math.pow(-2, i);
            //System.out.println(p);
            t+=p;
        }
        return t;
    }
    public static void main(String[] args) {
        int[] a =  {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1};
        int[] b =  {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1};


//        System.out.println("deci a: "+convert(a));
//        System.out.println("deci b: "+convert(b));
//        int[] r = negBinary(convert(a)+convert(b));
//
//        for (int i = 0; i < r.length; i++) {
//            System.out.print(r[i] +", ");
//        }
//        System.out.println("match: " + convert(r));
            negBinary(9);
            negBinary(18);
//        for (int i = 0; i < r.length; i++) {
//            System.out.print(r[i] +", ");
//        }
//        int[] r =toBinary(11);
//        for (int i = 0; i < r.length; i++) {
//            System.out.print(r[i] +", ");
//        }

        //System.out.println(9%-2);
    }

    public static int[] negBinary(int value)
    {
        System.out.println("\n negBinary for: " + value +" ");
        List<Integer> result = new ArrayList<>();
        while (value != 0)
        {
            int remainder = value % -2;

            value = value / -2;
            //System.out.println("reminder: "+ remainder + " value: "+ value);
            if (remainder < 0)
            {
                remainder += 2;
                value += 1;
            }

            System.out.print(remainder +" ,");
            result.add(remainder);
        }

        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return r;
    }

    public static int[] toBinary(int v){
        List<Integer> r = new ArrayList<>();

        while(v !=0){
            int d = v %2;
            System.out.println("val: " + v + " reminder :" +d);
            r.add(d);
            v = v/2;
        }

        int[] ar = new int[r.size()];
        for (int i = r.size(); i >0; i--) {
            ar[r.size()-i] = r.get(i-1);
        }
        return ar;
    }
}
