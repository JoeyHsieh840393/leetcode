public class Q24 {
    public static ListNode swapParis(ListNode head) {
        if(head == null) {
            return null;
        }
        
        if(head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode previous = dummy;
        ListNode current = dummy.next;

        while(current != null) {
            previous.next = current.next;
            current.next = previous.next.next;
            previous.next.next = current;

            previous = current;
            current = current.next;
        }

        return dummy.next;
    }

    public static String retrieveListNode(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        ListNode current = head;

        while(current != null) {
            sb.append(current.val);

            if(current.next != null) {
                sb.append(", ");
            }

            current = current.next;
        }

        return sb.append("]").toString();
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
        
        node1.next = node2;
        node2.next = node3;
//      node3.next = node4;

        System.out.println(retrieveListNode(node1));
        ListNode result = swapParis(node1);
        System.out.println(retrieveListNode(result));
    }
}
