package com.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

public class Q144 {

    public static void main(String[] args) {

        TreeNode root = buildTree(new Integer[] { 1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9 });

        List<Integer> result = preorderTraversal(root);
        System.out.println(result);

        System.out.println(preorderTraversalByRecursive(root));

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            result.add(current.val);

            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return result;

    }

    public static List<Integer> preorderTraversalByRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(result, root);
        return result;
    }

    private static void helper(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        helper(result, root.left);
        helper(result, root.right);
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
