package sorting;

public class SelectionSort implements BasicSort{

    //Select the min and put at beginning, repeat
    @Override
    public int[] sort(int[] n){

        print(n);
        for(int i=0; i<n.length;i++){
            int min = n[i];
            int minIdx  = i;
            for(int j=i; j< n.length;j++){
                if(n[j]<min){
                    min = n[j];
                    minIdx = j;
                }
            }
            if(min<n[i]) {
                int t = n[i];
                n[i] = min;
                n[minIdx] = t;
            }

            print(n);
        }

        return n;
    }

    public static void main(String[] args) {
        int[] n = {20, 35, -15, 7, 55, 1, -22};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(n);
    }
}
