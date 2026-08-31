package com.example;

import java.util.ArrayList;
import java.util.List;

public class Q257 {
    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        List<String> list = new ArrayList<>();

        help(root, list, new StringBuilder());
        return list;
    }

    private static void help(TreeNode root, List<String> list, StringBuilder sb) {
        sb.append(root.val);
        int length = sb.length();

        if (root.left == null && root.right == null) {
            list.add(sb.toString());
            return;
        }

        if (root.left != null) {
            help(root.left, list, sb.append("->"));
            sb.setLength(length);
        }

        if (root.right != null) {
            help(root.right, list, sb.append("->"));
            sb.setLength(length);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        System.out.println(binaryTreePaths(root));
    }
}
