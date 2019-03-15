package search;

public class MyBinarySearch {

    public static boolean search(int[] ar, int l, int r, int s){
        if(l>r){
            return false;
        }

        int m = (l+r)/2;

        if(s==ar[m]){
            return true;
        } else if(s > ar[m]){
            return search(ar, m+1, r, s);
        } else {
            return search(ar, l, m-1, s);
        }
    }

    public static boolean search(int[] ar, int s){
        return search(ar, 0, ar.length-1, s);
    }

    public static void main(String[] args) {
        int[] ar = {1, 3, 5, 7, 15, 34, 76};

        boolean flag = search(ar, 15);

        System.out.println("Found the number: " + flag);
    }
}
