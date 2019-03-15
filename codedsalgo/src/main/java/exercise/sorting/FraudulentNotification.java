package exercise.sorting;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FraudulentNotification {// Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        List<Integer> set = new LinkedList<>();
        boolean isEven = d%2==0 ? true : false;
        int count=0;
        int m = (d-1)/2;

        for (int i = 0; i < d; i++) {
            set.add(expenditure[i]);
        }

        //set.stream().forEach(o -> System.out.println(o + ", "));
        for (Integer i :
             set) {
            System.out.print(i +", ");
        }


        for (int i = d; i < expenditure.length; i++) {
            Iterator<Integer> it = set.iterator();
            int j=0;
            double med=0;
            while(it.hasNext()){
                double v = it.next();
                if(j==m) {
                    if (isEven) {
                        med = (v + it.next()) / 2;
                    } else {
                        med = it.next();
                    }
                    break;
                }
                j++;
            }
            System.out.println("set before: ");
            set.forEach(h -> System.out.println(h + ", "));

            System.out.println("med: " +med);
            if(expenditure[i] >= (2*med)){
                count++;
            }


            Iterator<Integer> it2 = set.iterator();
            int k=0;
            while(it2.hasNext()){
                Integer p = it2.next();
                if(k==0){
                    set.remove(p);
                    break;
                }
                k++;
            }
            set.add(expenditure[i]);

            System.out.println("set before: ");
            set.forEach(h -> System.out.println(h + ", "));
        }
        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);
        System.out.println(result);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();
        //
        //bufferedWriter.close();

        scanner.close();
    }
}

