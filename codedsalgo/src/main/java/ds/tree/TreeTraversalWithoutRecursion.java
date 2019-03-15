package ds.tree;

import java.util.Stack;

//using stack
public class TreeTraversalWithoutRecursion {
    static BinaryTree tree = new BinaryTree();

    //inorder traversal (left root right)
    private static void traverseInOrder() {
        Node curr = tree.root;
        Stack<Node> s = new Stack<>();

        while (curr != null || s.size() > 0) {

            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            System.out.print(curr.key + ", ");

            curr = curr.right;

        }

    }

    //inorder traversal (ROOT left right)
    private static void traversePreOrder() {
        Node curr = tree.root;
        Stack<Node> s = new Stack<>();

        while (curr != null || s.size() > 0) {

            while (curr != null) {
                System.out.print(curr.key + ", ");
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            curr = curr.right;

        }

    }

    //inorder traversal (left root right)
    private static void traversePostOrder() {
        Node curr = tree.root;
        Stack<Node> s = new Stack<>();

        while (curr != null || s.size() > 0) {

            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            curr = curr.right;
            System.out.print(curr.key + ", ");
        }

    }
    public static void main(String[] args) {
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Pre Order");
        traversePreOrder();
        System.out.println("In Order");
        traverseInOrder();
        System.out.println("Post Order");
        traversePostOrder();
    }
}
