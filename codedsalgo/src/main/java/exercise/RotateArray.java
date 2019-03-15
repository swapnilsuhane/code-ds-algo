package exercise;

public class RotateArray {

    private static int[] solution(int[] i, int r){
        if(r>i.length){
            r = r % 7;
        }

        if(r < 0){
            return i;
        }
        int[] res = new int[i.length];
        for(int a=r, b=0; a<i.length; a++, b++){
            res[b] = i[a];
        }

        for(int a=0, b=res.length-r; a<r; a++, b++){
            res[b] = i[a];
        }
        return res;
    }

    private static int[] solution2(int[] i, int r){
        //validation
        if(r>i.length){
            r = r % 7;
        }
        if(r < 0){
            return i;
        }

        //start using recursion
        solution2(i, r-1);

        if(r!=1) {
            int t = i[0];
            for (int a = 1; a < i.length; a++) {
                i[a - 1] = i[a];
            }
            i[i.length - 1] = t;
        }

        return i;
    }

    public static void main(String[] args) {
        int[] i = {1,2,3,4,5,6,7};
        int rotate = 9;

        int[] j = solution(i, rotate);
        System.out.println("result 1: ");

        for(int k : j){
            System.out.print(k + ", ");
        }

        int[] j2 = solution2(i, rotate);
        System.out.println("\nresult 2: ");

        for(int k : j2){
            System.out.print(k + ", ");
        }
    }
}
