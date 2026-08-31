package com.example;

public class BalancedBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static Boolean isBalanced(TreeNode root) {

        return Math.abs(getHeight(root)) <= 1;
    }

    private static int getHeight(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int hl = getHeight(root.left);
        int hr = getHeight(root.right);
        int bf = Math.abs(hl - hr);

        if (bf > 1) {
            return hl - hr;
        }

        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node2_1 = new TreeNode(22);
        root.left = node2;
        root.right = node2_1;

        TreeNode node3 = new TreeNode(3);
        TreeNode node3_1 = new TreeNode(3);
        node2.left = node3;
        node2.right = node3_1;

        TreeNode node4 = new TreeNode(4);
        TreeNode node4_1 = new TreeNode(4);
        node3.left = node4;
        node3.right = node4_1;

        System.out.println(isBalanced(root));

    }
}
