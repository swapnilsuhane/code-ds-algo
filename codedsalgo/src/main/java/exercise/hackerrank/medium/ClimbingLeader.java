package exercise.hackerrank.medium;

import java.io.IOException;
import java.util.*;

public class ClimbingLeader {

    private static int searchClosest(int[] s, int search, int start, int end){
        if(start>end){
            return start>s.length-1 ? s.length-1 : start;
        }
        int mid = (start+end)/2;

        if(search==s[mid]){
            return mid;
        } else if(search<s[mid]){
            return searchClosest(s, search, mid+1, end);
        } else {
            return searchClosest(s, search, start, mid-1);
        }
    }

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] result = new int[alice.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, j=1; i < scores.length; i++) {
            if(!map.containsKey(scores[i])){
                map.put(scores[i], j++);
            }
        }

        //System.out.println(map);

        for (int i = 0; i < alice.length; i++) {
            if(alice[i]>scores[0]){
                result[i] = 1;
            } else {
                int closest = searchClosest(scores, alice[i], 0, scores.length - 1);
                //System.out.println(alice[i] + " closest: " +scores[closest]);
                if(alice[i]<scores[closest]){
                    result[i] = map.get(scores[closest])+1;
                } else {
                    result[i] = map.get(scores[closest]);
                }
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            System.out.println(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.println("\n");
            }
        }

        scanner.close();
    }
}

