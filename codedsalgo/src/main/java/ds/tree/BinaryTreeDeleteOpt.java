package main.java.ds.tree;

public class BinaryTreeDeleteOpt {
    static Node found;

    private static Node findRightMostNode(Node node){
        Node n = node;
        if(n!=null && n.right!=null){
            n = findRightMostNode(n.right);
        }
        return n;
    }

    private static void deleteRightMostNode(Node n){
        if(n!=null && n.right!=null){
            deleteRightMostNode(n.right);
        }

        if(n!=null && n.right ==null) {
            n = null;
        }
    }

    private static Node findNode(Node n, int key){
        if(n != null && n.key == key){
            found = n;
        }

        if(n != null && n.left != null){
            findNode(n.left, key);
        }

        if(n!=null && n.right!=null){
            findNode(n.right, key);
        }

        return found;
    }



    //the deleted node is replaced by bottom most and rightmost node
    public static void deleteNode(BinaryTree binaryTree, int key){
        Node rt = findRightMostNode(binaryTree.root);
        System.out.println("right most node is: " + rt.key);
        findNode(binaryTree.root, key).key = rt.key;

        deleteRightMostNode(binaryTree.root);

        //Node node = findNode(binaryTree.root, key);
        //if(node !=null){
        //    System.out.println("found the node: " + node.key);
        //} else{
        //    System.out.println("Node not found with key: " +key);
        //}
        //


    }

    public static void main(String[] args) {
        BinaryTree binaryTree = BinaryTree.initTree();
        BinaryTree.printTree(binaryTree);
        deleteNode(binaryTree, 2);

        BinaryTree.printTree(binaryTree);
    }

    //Delete 10 in below tree
    //         10
    //       /    \
    //       20     30
    //Output :
    //    30
    //    /
    //    20
    //
    //
    //Delete 20 in below tree
    //   10
    //       /    \
    //       20     30
    //       \
    //       40
    //Output :
    //    10
    //    /   \
    //    40    30
}
