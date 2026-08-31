package com.example;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q94 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;
        root.right = node3;

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node2.left = node4;
        node2.right = node5;

        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node3.left = node6;
        node3.right = node7;

        List<Integer> solu = inorderTraversal(root);
        System.out.println(solu);

        System.out.println(inorderTraversalByRecursive(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        if (root == null) {
            return nums;
        }

        TreeNode current = root;
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            nums.add(current.val);

            current = current.right;
        }

        return nums;
    }

    public static List<Integer> inorderTraversalByRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(result, root);
        return result;
    }

    private static void helper(List<Integer> result, TreeNode node) {
        if (node == null) {
            return;
        }

        helper(result, node.left);
        result.add(node.val);
        helper(result, node.right);
    }
}
