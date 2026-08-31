package com.example;

public class Q203 {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;

        ListNode prev = sentinel;
        ListNode current = sentinel.next;

        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;

                current = current.next;
            } else {
                prev = current;
                current = current.next;
            }
        }

        return sentinel.next;
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
