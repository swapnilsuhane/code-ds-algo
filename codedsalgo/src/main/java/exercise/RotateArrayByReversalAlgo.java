package exercise;

public class RotateArrayByReversalAlgo {
    private static int[] solution(int[] i, int r) {
        if (r > i.length) {
            r = r % 7;
        }

        if (r < 0) {
            return i;
        }

        int[] lt = new int[r];
        int[] rt = new int[i.length-r];

        //divide
        for (int p=0, q=0; p< i.length; p++){
            if (p<r){
                lt[p] = i[p];
            } else{
                rt[q] = i[p];
                q++;
            }
        }

        lt = reverse(lt);
        rt = reverse(rt);

        //combine
        for (int p=0, q=0; p< i.length; p++){
            if (p<r){
                i[p] = lt[p];
            } else{
                i[p] = rt[q];
                q++;
            }
        }

        return reverse(i);
    }


    /* Function to left rotate arr[] of size n by d */
    static int[] solution2(int arr[], int d)
    {
        int n = arr.length;
        rvereseArray(arr, 0, d-1);
        rvereseArray(arr, d, n-1);
        rvereseArray(arr, 0, n-1);

        return arr;
    }

    /*Function to reverse arr[] from index start to end*/
    static void rvereseArray(int arr[], int start, int end)
    {
        int temp;
        while (start < end)
        {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private static int[] reverse(int[] i){
        for(int a=0, b=i.length-1; a<i.length/2; a++, b--){
            int t = i[a];
            i[a] = i[b];
            i[b] = t;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] i = {1, 2, 3, 4, 5, 6, 7};
        int[] i2 = {1, 2, 3, 4, 5, 6, 7};

        int rotate = 2;

        int[] j = solution(i, rotate);
        System.out.println("result: ");

        for(int k : j){
            System.out.print(k + ", ");
        }

        int[] j2 = solution2(i2, rotate);
        System.out.println("\nresult 2: ");

        for(int k : j2){
            System.out.print(k + ", ");
        }
    }
}
