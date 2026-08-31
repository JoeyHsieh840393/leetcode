public class Q2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();

        help(l1, l2, 0, result);

        return result.next;
    }

    private static void help(ListNode l1, ListNode l2, int carry, ListNode result) {

        int x = 0, y = 0;

        if (l1 != null) {
            x = l1.val;
            l1 = l1.next;
        }

        if (l2 != null) {
            y = l2.val;
            l2 = l2.next;
        }

        int sum = x + y + carry;

        result.val = sum % 10;
        carry = sum / 10;

        if (l1 != null || l2 != null || carry == 1) {
            result.next = new ListNode();
            help(l1, l2, carry, result.next);
        }

    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode head = result;
        int carry = 0;

        while (l1 != null || l2 != null || carry == 1) {
            int x = 0, y = 0;
            if (l1 != null) {
                x = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                y = l2.val;
                l2 = l2.next;
            }

            int sum = x + y + carry;

            result.val = sum % 10;
            carry = sum / 10;

            result.next = new ListNode();
            result = result.next;
        }

        return head;
    }
}
