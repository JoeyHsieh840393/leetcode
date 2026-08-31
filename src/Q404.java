package com.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q404 {

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }

        sum += sumOfLeftLeaves(root.right);

        return sum;
    }

    public static int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);
        int sum = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        sumOfLeftLeaves(new TreeNode(1, new TreeNode(2), new TreeNode(3)));
    }
}
