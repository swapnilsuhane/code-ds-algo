package exercise;

public class IndeedDarknessSolution {
    static int[][] mt;
    static int sum;

    //ar - matrix, d[0]=x-coordinate, d[1]=y-coordinate d[2]=darkness index
    static void solution(int[][] ar, int[][] d){
        System.out.println("matrix size: " + ar.length + ", " + ar[0].length);
        for (int k = 0; k < d.length; k++) {
            int x=d[k][0]; //0
            int y=d[k][1]; //0
            int idx=d[k][2]; //255

            for (int i = ar.length-1; i >=0; i--) {
                for (int j = ar[0].length-1; j >= 0; j--) {
                    int diff = Math.abs(i-x)>Math.abs(j-y)?Math.abs(i-x):Math.abs(j-y);

                    if(idx - diff > ar[i][j]) {
                        ar[i][j] = idx - diff;
                    }
                }
            }
        }
    }

    private static void print(){
        for (int i = 0; i <mt.length; i++) {
            for (int j = 0; j<mt[0].length; j++) {
                System.out.print(mt[i][j] + " - ");
                sum = sum + mt[i][j];
            }
            System.out.println();
        }

        System.out.println("Sum - " +sum);
    }

    public static void main(String[] args) {
        mt = new int[6][6];
        int d[][]= {{0,0,10}, {1,1,9}, {4,4,8}};
        solution(mt, d);
        print();

    }
}
