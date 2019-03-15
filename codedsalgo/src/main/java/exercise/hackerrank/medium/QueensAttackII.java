package exercise.hackerrank.medium;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class QueensAttackII {

        static boolean isObstacle(int[][] obstacles, int r, int c){
            for (int i = 0; i < obstacles.length; i++) {
                if(obstacles[i][0] ==r && obstacles[i][1]==c){
                    return true;
                }
            }
            return false;
        }

        static int countUp(int n, int k, int r_q, int c_q, TreeMap<String, String> map){
            int c=0;
            r_q++;
            while(n>=r_q){
                if(map.containsKey(String.valueOf(r_q)+String.valueOf(c_q))) {
                    return c;
                }
                c++;
                r_q++;
            }
            return c;
        }

        static int countDown(int n, int k, int r_q, int c_q, TreeMap<String, String> map){
            int c=0;
            r_q--;
            while(r_q>=1){
                if(map.containsKey(String.valueOf(r_q)+String.valueOf(c_q))) {
                    return c;
                }
                c++;
                r_q--;
            }
            return c;
        }

        static int countLeft(int n, int k, int r_q, int c_q, TreeMap<String, String> map){
            int c=0;
            c_q--;
            while(c_q>=1){
                if(map.containsKey(String.valueOf(r_q)+String.valueOf(c_q))) {
                    return c;
                }
                c++;
                c_q--;
            }
            return c;
        }

        static int countRight(int n, int k, int r_q, int c_q, TreeMap<String, String> map){
            int c=0;
            c_q++;
            while(n>=c_q){
                if(map.containsKey(String.valueOf(r_q)+String.valueOf(c_q))) {
                    return c;
                }
                c++;
                c_q++;
            }
            return c;
        }

        static int countLeftUp(int n, int k, int r_q, int c_q, TreeMap<String, String> map){
            int c=0;
            r_q++;
            c_q--;
            while(r_q<=n && c_q>=1){
                if(map.containsKey(String.valueOf(r_q)+String.valueOf(c_q))) {
                    return c;
                }
                c++;
                r_q++;
                c_q--;
            }
            return c;
        }

        static int countRightDown(int n, int k, int r_q, int c_q, TreeMap<String, String> map){
            int c=0;
            r_q--;
            c_q++;
            while(c_q<=n && r_q>=1){
                if(map.containsKey(String.valueOf(r_q)+String.valueOf(c_q))) {
                    return c;
                }
                c++;
                c_q++;
                r_q--;
            }
            return c;
        }

        static int countLeftDown(int n, int k, int r_q, int c_q, TreeMap<String, String> map){
            int c=0;
            r_q--;
            c_q--;
            while(c_q>=1 && r_q>=1){
                if(map.containsKey(String.valueOf(r_q)+String.valueOf(c_q))) {
                    return c;
                }
                c++;
                c_q--;
                r_q--;
            }
            return c;
        }

        static int countRightUp(int n, int k, int r_q, int c_q, TreeMap<String, String> map){
            int c=0;
            r_q++;
            c_q++;
            while(c_q<=n && r_q<=n){
                if(map.containsKey(String.valueOf(r_q)+String.valueOf(c_q))) {
                    return c;
                }
                c++;
                c_q++;
                r_q++;
            }
            return c;
        }
        // Complete the queensAttack function below.
        static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
            TreeMap<String, String> map = new TreeMap<>();
            for (int i = 0; i < obstacles.length; i++) {
                map.put(String.valueOf(obstacles[i][0])+String.valueOf(obstacles[i][1]), "Value");
            }
            int c = 0;
            c = c +  countUp(n, k, r_q, c_q, map);
            c = c +  countDown(n, k, r_q, c_q, map);
            c = c +  countLeft(n, k, r_q, c_q, map);
            c = c +  countRight(n, k, r_q, c_q, map);
            c = c +  countLeftUp(n, k, r_q, c_q, map);
            c = c +  countLeftDown(n, k, r_q, c_q, map);
            c = c +  countRightUp(n, k, r_q, c_q, map);
            c = c +  countRightDown(n, k, r_q, c_q, map);

            return c;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) throws IOException {

            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            String[] r_qC_q = scanner.nextLine().split(" ");

            int r_q = Integer.parseInt(r_qC_q[0]);

            int c_q = Integer.parseInt(r_qC_q[1]);

            int[][] obstacles = new int[k][2];

            for (int i = 0; i < k; i++) {
                String[] obstaclesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                    obstacles[i][j] = obstaclesItem;
                }
            }

            int result = queensAttack(n, k, r_q, c_q, obstacles);

            System.out.println(result);

            scanner.close();
        }
    }
