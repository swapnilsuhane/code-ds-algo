package main.java.ds.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InorderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return new ArrayList<Integer>();
        } else if (root.left == null && root.right == null) {
            return Arrays.asList(root.val);
        }


        return res;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
