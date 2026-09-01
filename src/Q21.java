public class Q21 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        System.out.println(printListNode(list1));
        System.out.println(printListNode(list2));

        ListNode node = mergeTwoLists(list1, list2);

        System.out.println(printListNode(node));
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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        helper(list1, list2, current);

        return dummy.next;
    }

    private static void helper(ListNode list1, ListNode list2, ListNode result) {
        if(list1 == null && list2 == null) {
            return;
        }

        if(list1 == null) {
            result.next = list2;
            return;
        }

        if(list2 == null) {
            result.next = list1;
            return;
        }

        if(list1.val > list2.val) {
            result.next = list2;
            helper(list1, list2.next, result.next);
        }else {
            result.next = list1;
            helper(list1.next, list2, result.next);
        }
    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }

        if(list2 == null) {
            return list1;
        }

        if(list1.val > list2.val) {
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;
        } else {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list2;
        }
    }
    private static String printListNode(ListNode head) {
        StringBuilder sb = new StringBuilder("[");

        ListNode current = head;

        while(current != null) {
            sb.append(current.val);

            current = current.next;

            if(current == null) {
                sb.append("]");
            }else {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
