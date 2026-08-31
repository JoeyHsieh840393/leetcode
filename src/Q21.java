package com.example;

public class Q21 {
    public static void main(String[] args) {
        ListNode node = solution(null, new ListNode(0, new ListNode(1)));

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode solution(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }

        cur.next = (list1 != null) ? list1 : list2;

        return dummy.next; 
    }
}