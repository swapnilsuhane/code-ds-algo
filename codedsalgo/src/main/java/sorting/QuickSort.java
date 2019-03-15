package sorting;

public class QuickSort implements BasicSort {

    //select pivot and sort left, right of pivot by divide and conquer algo
    private int[] sort(int[] ar, int low, int high) {
        if (low < high) {
            int pi = partition(ar, low, high);

            sort(ar, low, pi-1);
            sort(ar, pi+1, high);
        }
        return ar;
    }

    private int partition(int[] ar, int low, int high) {
        int pivot = high;
        int idx = low-1;

        for (int i = low; i < high; i++) {
            if(ar[i] <= ar[pivot]){
                idx++;
                int tmp = ar[idx];
                ar[idx] = ar[i];
                ar[i] = tmp;
            }
        }

        int tmp =  ar[idx+1];
        ar[idx+1] = ar[high];
        ar[high] = tmp;

        System.out.println("Pivot: " + ar[idx+1]);
        print(ar);

        return idx+1;
    }

    @Override
    public int[] sort(int[] ar) { return sort(ar, 0, ar.length-1);
    }

    public static void main(String[] args) {
        int[] n = {20, 35, -15, 7, 55, 1, -22};
        QuickSort quickSort = new QuickSort();
        quickSort.print(n);
        quickSort.sort(n);
    }
}
