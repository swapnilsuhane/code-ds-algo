package sorting;

public class InsertionSort implements BasicSort {

    //fix it later todo
    //extract an element and insert at its correct position (ex. cards game)
    @Override
    public int[] sort(int[] n){
        print(n);
        for(int i=0; i<n.length-1;i++){
            int e = n[i+1];
            if(n[i] > e){
                for (int j = i; j > 0; j--) {
                    if ((e < n[j] && j==1) || (e < n[j] && e > n[j-1])){
                        int t = e;
                        n[i+1] = n[j-1];
                        n[j-1] = t;
                    }
                }
            }

            print(n);
        }

        return n;
    }

    public static void main(String[] args) {
        int[] n = {20, 35, -15, 7, 55, 1, -22};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(n);
    }

}
