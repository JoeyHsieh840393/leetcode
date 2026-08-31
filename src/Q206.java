package com.example;

public class Q206 {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode prev = head;
        ListNode current = prev.next;

        while (current != null) {
            ListNode temp = current.next;

            current.next = prev;

            prev = current;
            current = temp;
        }

        head.next = null;
        head = prev;

        return head;
    }

    public static ListNode reverseList2(ListNode head) {
        return handler(null, head);
    }

    private static ListNode handler(ListNode prev, ListNode current) {
        if (current == null) {
            return prev;
        }

        ListNode temp = current.next;
        current.next = prev;

        return handler(current, temp);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
