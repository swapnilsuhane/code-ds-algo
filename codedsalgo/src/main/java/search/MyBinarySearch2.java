package search;


//desc order + duplicates
public class MyBinarySearch2 {

    private static int search(int[] ar, int n, int start, int end){
        if(start>=end){
            if(start==end && ar[start]==n) {
                return start;
            }else {
                return -1;
            }
        }
        int mid = (start+end)/2;

        if(ar[mid]==n){
            return mid;
        } else if(ar[mid]<n){
            end = mid-1;
        } else if(ar[mid]>n){
            start = mid+1;
        }

        return search(ar, n, start, end);
    }

    public static void main(String[] args) {
        int[] ar = {100, 100, 50, 40, 40, 20, 10, 5, 2};
        System.out.println("search index: " + search(ar, 2, 0, ar.length-1));
    }
}
