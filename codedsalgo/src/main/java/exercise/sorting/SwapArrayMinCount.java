package main.java.exercise.sorting;

public class SwapArrayMinCount {

    private static int count(int[] ar){
        int c=0;
        for (int i = 0; i < ar.length-1; i++) {
            if(ar[i]>ar[i+1]){
                for(int j = 0; j < ar.length-1;j++) {
                    if(ar[j]>ar[i+1]){
                        System.out.println(ar[i+1] + " swap with "+ar[j]);
                        //swap
                        int t = ar[j];
                        ar[j] = ar[i+1];
                        ar[i+1] = t;
                        c++;
                    }
                    for(int k = 0; k < ar.length;k++) {
                        System.out.print(ar[k] +", ");
                    }
                    System.out.println();
                }
            }
        }

        return c;
    }


    public static void main(String[] args) {
        //int[] ar = {1,3,4,2};
        int[] ar = {2,4,5,1,3};
        System.out.println("Ans: " + count(ar));
    }
}
