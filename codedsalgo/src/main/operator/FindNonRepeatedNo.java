package main.operator;

public class FindNonRepeatedNo {

    private static int find(int[] a){
        int n = 0;

        for (int i = 0; i < a.length; i++) {
            n = n ^ a[i];
            System.out.println(a[i] + "-" +n);
        }
        return n;
    }



    public static void main(String[] args) {
        int[] a = {1,2,5,4,6,8,9,2,1,4,5,8,9};
        System.out.println("ans: " + find(a));
    }
}
