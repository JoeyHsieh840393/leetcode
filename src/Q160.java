package com.example;

public class Q160 {
    public static void main(String[] args) {
        Q160 list1 = new Q160();
        list1.add(new int[] { 1, 9, 1 });

        Q160 list2 = new Q160();
        list2.add(new int[] { 3 });

        Q160 list3 = new Q160();
        list3.add(new int[] { 8, 4, 5 });

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);

        list1.append(list3.getHead());
        list2.append(list3.getHead());
        System.out.println(list1);
        System.out.println(list2);

        System.out.println(getIntersectionNode2(list1.head, list2.head).val);
    }

    private ListNode head;
    private ListNode tail;

    public ListNode getHead() {
        return head;
    }

    public void add(int[] vals) {
        for (int val : vals) {
            add(val);
        }
    }

    public void add(int val) {
        if (head == null) {
            head = new ListNode(val);
            tail = head;
        } else {
            tail.next = new ListNode(val);

            tail = tail.next;
        }
    }

    public void append(ListNode node) {
        if (head == null && tail == null) {
            return;
        }

        tail.next = node;
        tail = tail.next;
    }

    @Override
    public String toString() {
        if (head == null && tail == null) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");

        ListNode current = head;

        while (current != null) {
            sb.append(current.val);

            if (current.next != null) {
                sb.append(" -> ");
            } else {
                sb.append("]");
            }

            current = current.next;
        }

        return sb.toString();
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currentA = headA;
        ListNode currentB = headB;

        int m = 0;
        int n = 0;
        while (currentA != null) {
            m++;
            currentA = currentA.next;
        }

        while (currentB != null) {
            n++;
            currentB = currentB.next;
        }

        currentA = headA;
        currentB = headB;

        if (m > n) {
            for (int i = 0; i < m - n; i++) {
                currentA = currentA.next;
            }
        } else {
            for (int i = 0; i < n - m; i++) {
                currentB = currentB.next;
            }
        }
        while (currentA != null && currentB != null) {
            if (currentA == currentB) {
                return currentA;
            }
            currentA = currentA.next;
            currentB = currentB.next;
        }

        return null;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        ListNode currentA = headA;
        ListNode currentB = headB;

        while (currentA != currentB) {
            if (currentA != null) {
                currentA = currentA.next;
            } else {
                currentA = headB;
            }

            if (currentB != null) {
                currentB = currentB.next;
            } else {
                currentB = headA;
            }
        }

        return currentA;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
