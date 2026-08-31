package com.example;

public class Q101 {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSame(root.left, root.right);
    }

    public boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return isSame(left.left, right.left) && isSame(left.right, right.right);
    }
}
