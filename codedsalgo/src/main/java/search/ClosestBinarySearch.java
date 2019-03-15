package search;

public class ClosestBinarySearch {
    private static int search(int[] s, int search, int start, int end){
        if(start>end){
            return start>s.length-1 ? s.length-1 : start;
        }
        int mid = (start+end)/2;

        if(search==s[mid]){
            return mid;
        } else if(search<s[mid]){
            return search(s, search, mid+1, end);
        } else {
            return search(s, search, start, mid-1);
        }
    }

    public static void main(String[] args) {
        int[] ar = {100, 100, 50, 40, 40, 20, 10};
        System.out.println("Found the closest index: " + search(ar, 5, 0, ar.length-1));

    }

}
