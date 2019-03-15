package exercise.hackerrank.medium;

import com.sun.deploy.util.StringUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class TheTimeInWords {
    static HashMap<Integer, String> time = new HashMap<>();

    static {
        time.put(0, "o' clock");
        time.put(1, "one");
        time.put(2, "two");
        time.put(3, "three");
        time.put(4, "four");
        time.put(5, "five");
        time.put(6, "six");
        time.put(7, "seven");
        time.put(8, "eight");
        time.put(9, "nine");
        time.put(10, "ten");
        time.put(11, "eleven");
        time.put(12, "twelve");
        time.put(13, "thirteen");
        time.put(14, "fourteen");
        time.put(15, "quarter"); //special
        time.put(16, "sixteen");
        time.put(17, "seventeen");
        time.put(18, "eighteen");
        time.put(19, "nineteen");
        time.put(20, "twenty");
        time.put(21, "twenty one");
        time.put(22, "twenty two");
        time.put(23, "twenty three");
        time.put(24, "twenty four");
        time.put(25, "twenty five");
        time.put(26, "twenty six");
        time.put(27, "twenty seven");
        time.put(28, "twenty eight");
        time.put(29, "twenty nine");
        time.put(30, "half"); //special


    }
    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        String min = " minutes";
        if (m==1){
            min = " minute";
        } else if(m==15 || m==30 || m==45){
            min = "";
        }

        if(m==0){
            return time.get(h) + " " + time.get(m);
        } else if (m<=30){
            return time.get(m) + min  +" past " + time.get(h);
        } else {
            return time.get(60-m) + min + " to " + time.get(h+1);
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);
        System.out.println(result);

        //bufferedWriter.write(result);
        //bufferedWriter.newLine();
        //
        //bufferedWriter.close();

        scanner.close();
    }
}
