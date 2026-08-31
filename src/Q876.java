package com.example;

public class Q876 {
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        if (fast.next == null || fast.next.next == null) {
            return head;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
