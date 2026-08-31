package com.example;

public class RemoveDuplicatesFromSortedList {

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

    public static void main(String[] args) {
        ListNode case1 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2))));
        show(solution(case1));
        ListNode case2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        show(solution(case2));
    }

    public static ListNode solution(ListNode head) {
        ListNode currentNode = head;
        
        while (currentNode != null && currentNode.next != null) {
            ListNode nextNode = currentNode.next;

            if (currentNode.val == nextNode.val) {
                currentNode.next = nextNode.next;
                nextNode.next = null;
            }else{
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    private static void show(ListNode head) {
        ListNode current = head;

        System.out.print("[");
        while (current != null) {
            System.out.print(current.val);

            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }

        System.out.println("]");
    }
}
