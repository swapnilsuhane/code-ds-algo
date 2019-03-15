package sorting;

public class BubbleSort implements BasicSort{

    //Move bubble (each larger element) towards right one by one
    @Override
    public int[] sort(int[] n){

        for(int i=0; i<n.length;i++){
            for(int j=0; j< (n.length-1-i);j++){
                if(n[j] > n[j+1]){
                    int t = n[j];
                    n[j] = n[j+1];
                    n[j+1] = t;
                }
            }

            print(n);
        }

        return n;
    }

    public static void main(String[] args) {
        int[] n = {20, 35, -15, 7, 55, 1, -22};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(n);
    }
}
