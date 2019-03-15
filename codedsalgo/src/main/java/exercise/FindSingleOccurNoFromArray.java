package exercise;

import java.util.LinkedList;
import java.util.List;

public class FindSingleOccurNoFromArray {

    private static int[] solution(int[] n){
        List<Integer> l = new LinkedList<>();
        for (int i=0; i<n.length; i++){
            System.out.println("no: " + n[i]);
            if((i+1)!=n.length && n[i]==n[i+1]){
                i++;
                continue;
            } else{
                l.add(n[i]);
            }
        }

        int[] res = new int[l.size()];
        l.forEach(i -> {
            res[l.indexOf(i)] = i;
        });

        return res;
    }

    public static void main(String[] args) {
        int[] no = {7, 7, 8, 8, 9, 1, 1, 4, 2, 2, 3, 3};

        System.out.println("Result: ");
        for (int i : solution(no)){
            System.out.print(i + ", ");
        }
    }
}
