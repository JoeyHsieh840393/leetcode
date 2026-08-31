package com.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Q100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> queueP = new LinkedList<>();
        Deque<TreeNode> queueQ = new LinkedList<>();

        queueP.add(p);
        queueQ.add(q);

        while (!queueP.isEmpty() && !queueQ.isEmpty()) {
            TreeNode currP = queueP.poll();
            TreeNode currQ = queueQ.poll();

            if (currP == null && currQ == null) {
                continue;
            }

            if (currP == null || currQ == null) {
                return false;
            }

            if (currP.val != currQ.val) {
                return false;
            }

            queueP.offer(currP.left);
            queueQ.offer(currQ.left);
            queueP.offer(currP.right);
            queueQ.offer(currQ.right);
        }

        return true;
    }

    public static void main(String[] args) {
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.offer(null);
    }
}
