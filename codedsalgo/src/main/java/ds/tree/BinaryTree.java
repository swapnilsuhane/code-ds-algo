package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public BinaryTree() {
    }

    public static BinaryTree initTree(){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(5);
        binaryTree.root.right.left = new Node(6);
        binaryTree.root.right.right = new Node(7);
        return binaryTree;
    }

    private static int insertAtFirstEmptyNode(Node node, int key){
        int i=0;
        if(i!=-1) {
            if (node.left == null) {
                node.left = new Node(key);
                return -1;
            }
            if (node.right == null) {
                node.right = new Node(key);
                return -1;
            }
        }

        if(node.left != null || node.right !=null){
            i = insertAtFirstEmptyNode(node.left, key);
            i = insertAtFirstEmptyNode(node.right, key);
        }
        return -1;
    }

    public static void insertAtFirstEmptyNode(BinaryTree tree, int key){
        insertAtFirstEmptyNode(tree.root, key);
    }

    private static void printTree(Node node){

        if(node !=null) {
            System.out.println(node.key);
        }

        if(node.left !=null) {
            printTree(node.left);
        }
        if(node.right !=null) {
            printTree(node.right);
        }
    }

    public static void printTree(BinaryTree tree){
        printTree(tree.root);
    }

    /*function to insert element in binary tree */
    static void insert(Node temp, int key)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(temp);

        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            } else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            } else
                q.add(temp.right);
        }
    }

    /* Inorder traversal of a binary tree*/
    static void inorder(Node temp)
    {
        if (temp == null)
            return;

        inorder(temp.left);
        System.out.print(temp.key+" ");
        inorder(temp.right);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = initTree();
        inorder(binaryTree.root);
        System.out.println("Before: ");
        printTree(binaryTree);
        //insertAtFirstEmptyNode(binaryTree, 10);
        insert(binaryTree.root, 10);
        System.out.println("After: ");
        printTree(binaryTree);
        /* Tree looks like this
                    1
                /       \
               2          3
             /   \       /  \
            4     5     6    7
           /   \
          null null
         */
    }
}

class Node {
    int key;

    Node left, right;

    public Node(int key) {
        this.key = key;
        left = right = null;
    }
}
