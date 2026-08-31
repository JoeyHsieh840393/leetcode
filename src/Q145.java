package com.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

public class Q145 {
    public static void main(String[] args) {
        // TreeNode root = buildTree(new Integer[] { 1, 2, 3, 4, 5, null, 8, null, null,
        // 6, 7, 9 });
        TreeNode root = buildTree(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
        // System.out.println(postorderTraversalByRecursive(root));
        System.out.println(postorderTraversal(root));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode current = stack1.pop();
            stack2.push(current);

            if (current.left != null) {
                stack1.push(current.left);
            }

            if (current.right != null) {
                stack1.push(current.right);
            }

        }

        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }

        return result;
    }

    public static List<Integer> postorderTraversalByRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderByRecursive(root, result);

        return result;
    }

    private static void postorderByRecursive(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        postorderByRecursive(root.left, result);
        postorderByRecursive(root.right, result);
        result.add(root.val);
    }

    public static TreeNode buildTree(Integer[] data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot build tree: data is null");
        }

        if (data.length == 0) {
            throw new NoSuchElementException("Cannot build tree: data length is zero");
        }

        if (data[0] == null) {
            throw new IllegalArgumentException("Cannot build tree: First element is null");
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
}
