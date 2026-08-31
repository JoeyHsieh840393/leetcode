package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConvertSortedArrayToBinarySearchTree {
    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode arrayToTree(int[] nums) {

        return put(0, nums.length - 1, nums);
    }

    private static TreeNode put(int left, int right, int[] nums) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = put(left, mid - 1, nums);
        root.right = put(mid + 1, right, nums);

        return root;
    }

    public static Integer[] treeToArray(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current == null) {
                result.add(null);
            } else {
                result.add(current.val);
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }

        for (int i = result.size() - 1; i >= 0 && result.get(i) == null; i--) {
            result.remove(i);
        }

        return result.toArray(Integer[]::new);
    }

    public static void main(String[] args) {
        int[] nums = new int[] { -10, -3, 0, 5, 9 };
        TreeNode root = arrayToTree(nums);

        System.out.println(Arrays.toString(treeToArray(root)));
    }

}
