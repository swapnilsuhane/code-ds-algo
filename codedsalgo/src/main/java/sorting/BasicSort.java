package sorting;

public interface BasicSort {
    int[] sort(int[] n);

    default void print(int[] i){
        for (int j : i){
            System.out.print(j + ", ");
        }
        System.out.println();
    }
}
