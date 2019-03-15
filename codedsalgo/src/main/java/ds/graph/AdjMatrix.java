package ds.graph;

public class AdjMatrix {
    static Integer[][] am;

    static void initMatrix(String[] sa, int v){
        am = new Integer[v][v];
        //init the matrix with 0
        for (int i = 0; i < am.length; i++) {
            for (int j = 0; j < am[0].length; j++) {
                am[i][j]=0;
            }
        }
        for (String s: sa) {
            int x=Integer.valueOf(s.substring(0,1));
            int y=Integer.valueOf(s.substring(1));

            am[x][y] = 1;
            am[y][x] = 1;
        }
    }

    static void print(){
        System.out.println("Adjacency Matrix");
        for (int i = 0; i < am.length; i++) {
            for (int j = 0; j < am[0].length; j++) {
                System.out.print(am[i][j] +" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[] sa = {"01", "04", "14", "13", "12", "32", "34"};
        int noOfVertices = 5;
        initMatrix(sa, noOfVertices);
        print();
    }
}
