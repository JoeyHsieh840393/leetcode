public class ListNode {
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
}
