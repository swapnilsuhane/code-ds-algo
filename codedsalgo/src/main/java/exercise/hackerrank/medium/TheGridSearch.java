package exercise.hackerrank.medium;

import java.util.ArrayList;
import java.util.List;

public class TheGridSearch {

    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) {
        int len = P[0].length();
        for (int i = 0; i < G.length; i++) {
            //System.out.print("i: " + i + " ");
            if (G[i].contains(P[0])){
                int idx = G[i].indexOf(P[0]);
                List<Integer> idxList = new ArrayList<>();
                idxList.add(idx);
                int nextIndex = G[i].indexOf(P[0], idx + 1);
                //System.out.print("idx: " +idx +" nextIdx: "+nextIndex);
                while(nextIndex !=-1 && (nextIndex+P[0].length())<=G[0].length()){
                    //System.out.print("nextIndex: " +nextIndex);
                    idxList.add(nextIndex);
                    nextIndex = G[i].indexOf(P[0], nextIndex + 1);
                }
                for (int index: idxList) {
                    //System.out.println("index: " + index);
                    boolean match = false;
                    for (int j = 1, k = i + 1; j < P.length && k < G.length; j++, k++) {
                        String s = G[k].substring(index, index + len);
                        //System.out.println("substr: " + s);
                        if (!s.equals(P[j])) {
                            match = false;
                            break;
                        }
                        if (j == P.length - 1) {
                            match = true;
                        }
                    }
                    if (match) {
                        return "YES";
                    }
                }
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        String[] sa1 = {"123412","561212","123634","781288"};//{"7283455864" ,"6731158619","8988242643","3830589324","2229505813","5633845374","6473530293","7053106601","0834282956","4607924137"};
        String[] sa2 = {"12","34"}; //{"9535","3845","3530"};
        System.out.println(gridSearch(sa1, sa2));
    }
}
