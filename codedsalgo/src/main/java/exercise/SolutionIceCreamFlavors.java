package exercise;

import java.util.Arrays;
import java.util.Scanner;

public class SolutionIceCreamFlavors {

    static int search(int[] ar, int n, int l, int r){
        if(l>r){
            return -1;
        }

        int m = (l+r)/2;
        if(ar[m]==n){
            return m;
        } else if(n < ar[m]){
            return search(ar, n, l, m-1);
        } else {
            return search(ar, n, m+1, r);
        }
    }


    // Complete the whatFlavors function below
    static void whatFlavors(int[] cost, int money) {
        int x=0, y =0;
        int i1=0, i2 =0;
        boolean f1=false, f2=false;

        int[] ar = cost.clone();
        Arrays.sort(ar);


        for (int i = 0; i < ar.length; i++) {
                int m = money - ar[i];
                int r = search(ar, m, 0, ar.length-1);
                if(r != -1){
                    x = ar[i];
                    y = ar[r];
                    break;
                }
        }

        for (int i = 0; i < cost.length; i++) {
            if(cost[i]==x && !f1){
                i1 = i+1;
                f1=true;
                continue;
            }
            if(cost[i]==y && !f2){
                i2 = i+1;
                f2=true;
            }
        }

        if(i1<i2){
            System.out.println(i1 + " " + i2);
        } else{
            System.out.println(i2 + " " + i1);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
