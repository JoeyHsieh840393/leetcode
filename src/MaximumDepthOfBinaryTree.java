package com.example;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree(Integer[] data) {
        if (data == null || data.length == 0 || data[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(data[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (i < data.length) {
            TreeNode current = queue.poll();

            if (i < data.length && data[i] != null) {
                current.left = new TreeNode(data[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < data.length && data[i] != null) {
                current.right = new TreeNode(data[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static int maxDepth2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            depth++;
        }

        return depth;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[] { 3, 9, 20, null, null, 15, 7 };
        TreeNode root = buildTree(nums);
        System.out.println(maxDepth(root));
        System.out.println(maxDepth2(root));
    }
}
