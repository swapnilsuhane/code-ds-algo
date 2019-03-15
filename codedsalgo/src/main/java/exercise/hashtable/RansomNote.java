package exercise.hashtable;

import java.util.HashMap;
import java.util.Scanner;

public class RansomNote {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> map = new HashMap<>();
        boolean matched=true;
        for(String m : magazine){
            Integer i = map.putIfAbsent(m, 1);

            if(i!=null && i >= 1){
                map.put(m, map.get(m)+1);
            }
        }

        for(String n : note){
            Integer i = map.get(n);
            if(i !=null && map.get(n)>=1){
                if(i>1){
                    map.put(n, map.get(n)-1);
                }else{
                    map.remove(n);
                }
            } else{
                matched=false;
                break;
            }
        }

        if(matched) {
            System.out.println("Yes");
        } else{
            System.out.println("No");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
