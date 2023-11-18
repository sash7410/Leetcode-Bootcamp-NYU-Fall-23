import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        List<Integer> arr = new ArrayList<>();
        for (ListNode l : lists) {
            while (l != null) {
                arr.add(l.val);
                l = l.next;
            }
        }

        Collections.sort(arr);

        ListNode head = new ListNode(0);
        ListNode tmp = head;
        for (int val : arr) {
            tmp.next = new ListNode(val);
            tmp = tmp.next;
        }

        return head.next;
    }
}
