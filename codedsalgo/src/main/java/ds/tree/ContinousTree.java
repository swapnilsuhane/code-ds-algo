package ds.tree;

//A tree is Continuous tree if in each root to leaf path, absolute difference between keys of two adjacent is 1. We
// are given a binary tree, we need to check if tree is continuous or not.
public class ContinousTree {
    static BinaryTree tree = new BinaryTree();

    private static void init(){
        tree.root.key=3;
        tree.root.left.key=2;
        tree.root.right.key=4;
        tree.root.left.left.key=1;
        tree.root.left.right.key=3;
        tree.root.right.right.key=5;
    }

    private static boolean isContinousTree(Node node){
        boolean flag = false;
        Node tmp = node;
        while(tmp != null ) {
            if (tmp != null && tmp.left != null && Math.abs(tmp.key - tmp.left.key) == 1) {
                flag = true;
            } else {
                flag = false;
                break;
            }

            if (tmp != null && tmp.right != null && Math.abs(tmp.key - tmp.right.key) == 1) {
                flag = true;
            }
            else {
                flag = false;
                break;
            }

            if(tmp.left !=null || tmp.right !=null){
                if(tmp.left != null){
                    tmp = tmp.left;
                }

                if(tmp.right != null){
                    tmp = tmp.right;
                }
            }


        }

        while(node != null) {

            if (node != null && node.left != null && Math.abs(node.key - node.left.key) == 1) {
                flag = true;
            }
            if (node != null && node.right != null && Math.abs(node.key - node.right.key) == 1) {
                flag = true;
            }

            node = node.right;
        }

        return flag;
    }

    public static void main(String[] args) {
        init();
        isContinousTree(tree.root);
    }

      //     3
    //      / \
    //     2   4
    //    / \   \
    //   1   3   5

    // 3->2->1 every two adjacent node's absolute difference is 1
    // 3->2->3 every two adjacent node's absolute difference is 1
    // 3->4->5 every two adjacent node's absolute difference is 1
}
