package exercise;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class CommonManagerSkyS {

    /*
     * Complete the function below.
     */

    static void OutputCommonManager(int count, Scanner in) {
        in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String e1 = in.nextLine();
        String e2 = in.nextLine();
        //System.out.println(e1 + "-" + e2);
        String str = in.nextLine();
        List<String> re = new ArrayList<>();
        List<String> r1 = new ArrayList<>();
        List<String> r2 = new ArrayList<>();

        r1.add(e1);
        r2.add(e2);
        while(str !=null && str.length()>0){
            //System.out.println(str);
            String[] sa = str.split(" ");

            if(sa[1].equalsIgnoreCase(e1)){
                r1.add(sa[0]);
            } else if(sa[1].equalsIgnoreCase(e2)){
                r2.add(sa[0]);
            } else{
                re.add(str);
            }
            in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            str = in.nextLine();
        }

        int p=0;
        while (re.size()!=0 && p<re.size()){
            String s = re.get(p);
            String[] sa = s.split(" ");
            if(r1.contains(sa[1])){
                r1.add(sa[0]);
                re.remove(p);
            } else if(r2.contains(sa[1])){
                r2.add(sa[0]);
                re.remove(p);
            }
            p++;
        }

        boolean flag= false;
        for (int i = 0; i < r1.size(); i++) {
            for (int j = 0; j < r2.size(); j++) {
                if(r1.get(i).equalsIgnoreCase(r2.get(j))){
                    System.out.println(r1.get(i));
                    flag=true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }

    }

    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int _count;
        _count = Integer.parseInt(in.nextLine());

        OutputCommonManager(_count, in);
    }
}
