package ds.tree;

public class ReverseLevelOrderTraversal {
    static BinaryTree tree = new BinaryTree();

    private static void traverse(Node node){
        if(node.left!=null){
            System.out.println(node.key);
            traverse(node.left);
            if(node.right!=null){
                traverse(node.right);
            }



        }



    }

    private static void reverseTraverse(Node node){


    }

    public static void main(String[] args) {
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        traverse(tree.root);
        reverseTraverse(tree.root);

    }
}
