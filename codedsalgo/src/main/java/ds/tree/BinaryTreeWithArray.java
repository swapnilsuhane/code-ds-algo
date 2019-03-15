package ds.tree;

public class BinaryTreeWithArray {

    public static void main(String[] args) {
        Tree_Array treeArray = new Tree_Array();
        treeArray.Root("A");
        //treeArray.setLeft("B", 0);
        treeArray.setRight("C", 0);
        treeArray.setLeft("D", 1);
        treeArray.setRight("E", 1);
        treeArray.setLeft("F", 2);

        treeArray.printTree();
    }
}

class Tree_Array{
    static int i = 0;
    static String[] str = new String[10];

    public void Root(String key){
        str[0] = key;
    }

    public void setLeft(String key, int i){
        int j = (i * 2) + 1;

        if(str[i] ==null){
            System.out.println("There is no parent for this left child: " + key);
        } else{
            str[j] = key;
        }
     }


    public void setRight(String key, int i){
        int j = (i * 2) + 2;

        if(str[i] ==null){
            System.out.println("There is no parent for this right child: " + key);
        } else{
            str[j] = key;
        }
    }

    public void printTree(){
        for (int k = 0; k < str.length; k++) {
            if(str[k]!=null){
                System.out.print(str[k]);
            } else{
                System.out.print("-");
            }
        }
    }
}
