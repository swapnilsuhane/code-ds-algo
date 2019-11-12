package main.java.leetcode;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, List<Integer>> map = new HashMap(nums.length);
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], Arrays.asList(i));
            } else{
                List<Integer> l = new ArrayList(map.get(nums[i]).size());
                l.addAll(map.get(nums[i]));
                l.add(i);
                map.put(nums[i], l);
            }

        }

        //System.out.println(map);

        for(int i=0; i<nums.length; i++){
            int rem = target-nums[i];
            if(rem != nums[i]){
                if(map.containsKey(nums[i]) && map.containsKey(rem)){
                    res[0]=map.get(nums[i]).get(0);
                    res[1]=map.get(rem).get(0);
                    return res;
                }
            } else {
                if(map.get(nums[i]).size()>1){
                    res[0]=map.get(nums[i]).get(0);
                    res[1]=map.get(nums[i]).get(1);
                    return res;
                }
            }
        }
        return res;
    }
}
