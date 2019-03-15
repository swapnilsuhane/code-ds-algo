package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MyTree {
    static Node root;

    public void insert(int key){
        if(root==null){
            root = new Node(key);
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int h=1;
        while(!q.isEmpty()){
            Node n = q.peek();
            q.remove();

            if(n.left==null){
                n.left=new Node(key);
                return;
            } else{
                q.add(n.left);
            }

            if(n.right==null){
                n.right=new Node(key);
                return;
            }



            h++;
            if(h==2){
                break;
            }

        }
    }


    public static void main(String[] args) {
        MyTree tree = new MyTree();
        for (int i = 1; i < 4; i++) {
            tree.insert(i);
        }
    }



}
