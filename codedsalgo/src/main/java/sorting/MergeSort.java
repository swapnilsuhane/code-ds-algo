package sorting;

public class MergeSort implements BasicSort {

    private int[] merge(int[] ar, int l, int mid, int r){
        int n1 = mid - l +1;
        int n2 = r - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = ar[l + i];
        }

        for (int i = 0; i < n2; i++) {
            R[i] = ar[mid + 1 + i];
        }

        int i=0, j=0;
        int k = l;
        while(i < n1 && j< n2){
            if(L[i] <= R[j]){
                ar[k] = L[i];
                i++;
            }else{
                ar[k] = R[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            ar[k] = L[i];
            i++;
            k++;
        }

        while(j<n2){
            ar[k] = R[j];
            j++;
            k++;
        }
        System.out.print("Left: ");print(L);
        System.out.print("Right: ");print(R);
        print(ar);
        return ar;
    }

    //devide and conquer algorithm
    private int[] sort(int[] ar, int l, int r){
        int mid = (l+r)/2;
        if(l < r) {
            sort(ar, l, mid);
            sort(ar, mid+1, r);

            merge(ar, l, mid, r);
        }
        return ar;
    }

    @Override
    public int[] sort(int[] ar) {
        return sort(ar, 0, ar.length-1);
    }

    public static void main(String[] args) {
        int[] n = {20, 35, -15, 7, 55, 1, -22};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(n);
    }
}
