public class Q25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode predecessor = dummy;
        ListNode current = dummy.next;

        while(current != null) {
            ListNode temp = current;

            for(int i = 0; i < k; i++) {
                if(temp == null) {
                    return dummy.next;
                }
                temp = temp.next;
            }

            for(int j = 1; j < k; j++) {
                ListNode successor = current.next;
                current.next = successor.next;
                successor.next = predecessor.next;
                predecessor.next = successor;
            }

            predecessor = current;
            current = current.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        //ListNode node6 = new ListNode(6);
        
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        //node5.next = node6;

        System.out.println(ListNode.retrieveListNode(node1)); 
        ListNode result = reverseKGroup(node1, 3);
        System.out.println(ListNode.retrieveListNode(result)); 
    }
}
