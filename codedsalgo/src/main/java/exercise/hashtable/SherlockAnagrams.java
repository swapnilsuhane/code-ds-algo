package exercise.hashtable;

import java.io.*;
import java.util.*;

public class SherlockAnagrams {

    static boolean isStringAnagrams(String s1, String s2) {
        System.out.println(s1 + " + " + s2);
        String[] sa1 = s1.split("");
        String[] sa2 = s2.split("");
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : sa1) {
            Integer integer = map.computeIfAbsent(s, k -> map.put(s, 1));
            //System.out.println("int: "+ integer);
            if (integer != null) {
                //System.out.println("test1: "+ s);
                map.computeIfPresent(s, (k, v) -> {map.put(k, ++v);
                   // System.out.println("test2");
                    return v;});
            }
        }

        //map.forEach((k,v)-> System.out.println(k+ ": " +v));

        for (String s : sa2) {
            if (map.computeIfPresent(s, (k, v) -> {
                    if (map.get(s) > 1) {
                        map.put(k, v - 1);
                    } else {
                        map.remove(k);
                    }
                    return v; }) == null)
            {
                return false;
            }
        }
        return true;
    }

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int i=1;
        int count=0;
        while(i<=s.length()){
            for (int j = 0; j+i <= s.length(); j++) {
                String str1 = s.substring(j, j+i);
                for (int k = j+1; k+i <= s.length(); k++) {
                    String str2 = s.substring(k, k+i);
                    //System.out.println(i + " - " + j +" - "+k);
                    if(isStringAnagrams(str1, str2)){
                        count++;
                    }
                }

            }
            i++;
        }
        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            System.out.println(result);

            //bufferedWriter.write(String.valueOf(result));
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
