package main.java.test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class HelloWorld {

    private static int[] getIndexes(int[] idx, int max, int cur, int...var){
        for (int v: var) {
            if(v == max){
                return idx;
            }
            return getIndexes(idx, max, cur, v, v++);
            //System.out.println(v);
        }


        for(int i=0; i<idx.length; i++){
            cur = Math.max(cur, idx[i]++);
            System.out.println(idx[i] + " cur :" + cur);
            return getIndexes(idx, max, cur);
        }
        return idx;
    }

    private static String swap(String base, int i, int j){
        return base.substring(0, i) + base.substring(j, j+1)+ base.substring(i+1, j)+
        base.substring(i, i+1) + base.substring(j+1);
    }

    public static void main(String[] args) {



        byte[] n = new byte[3];
        n[0]=10;
        n[1]=10+10;
        n[2] = (byte) (n[0]+n[1]);
        System.out.println(n[2]);
        String s = "swap";
        //C U D

        LinkedList l = new LinkedList();
        System.out.println("Xor: "+  (1^5));


    }


}

