package com.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PathSum {
    private static class TreeNode {
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

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        
        int sum = 0;
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            sum += current.val;
            
            if (current.left == null && current.right == null) {
                return sum == targetSum;
            }
            
            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return sum == targetSum;
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

    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + ", ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1 };
        TreeNode root = buildTree(nums);

        System.out.println(hasPathSum(root, 22));
    }
}
