import java.util.ArrayList;
import java.util.List;

public class Q23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }

        while(lists.length > 1) {
            List<ListNode> temp = new ArrayList<>();
            for(int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = i + 1 < lists.length ? lists[i + 1] : null; 
                temp.add(mergeListNode(l1, l2));
            }
            lists = temp.toArray(new ListNode[0]);
        }
        return lists[0];
    }

    private static ListNode mergeListNode(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                current.next = l2;
                l2 = l2.next;
            } else {
                current.next = l1;
                l1 = l1.next;
            }
            current = current.next;
        }

        current.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}

