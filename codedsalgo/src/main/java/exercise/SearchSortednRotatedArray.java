package exercise;

public class SearchSortednRotatedArray {

    private static boolean solution(int[] n, int s){
        return search(n, s, 0, n.length-1);
    }

    private static boolean search(int[] n, int s, int l, int r){
        if(s > n[l] && s < n[r]){
            r = (l+r)/2;
        } else{
            l = (l+r)/2;
        }

        System.out.println(l + " - " + r);

        if(s==n[l] || s==n[r]){
            return true;
        } else if(l==r || l==0 || r==0){
            return false;
        }

        return search(n, s, l, r);

    }

    public static void main(String[] args) {
        int[] i = {3,4,5, 1,2};

        boolean res = solution(i, 10);
        System.out.println("result: " + res);



    }
}
