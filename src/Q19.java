public class Q19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        int count = 1;

        while(fast != null && count <= n) {
            fast = fast.next;
            count++;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }

    public static String retrievalListNode(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode current = head;

        while(current != null) {
            sb.append(current.val).append("->");
            current = current.next;
        }

        return sb.append("null").toString();
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        //node2.next = node3;
        //node3.next = node4;
        //node4.next = node5;
        //node5.next = node6;

        System.out.println(retrievalListNode(node1));
        ListNode head = removeNthFromEnd(node1, 1);
        System.out.println(retrievalListNode(head));
    }
}
