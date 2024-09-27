package leetcode.LL;

import leetcode.lib.ListNode;

public class _141 {
    public boolean hasCycle(ListNode head) {
        ListNode i = head;
        ListNode j = head;

        while (j != null && j.next != null) {
            j = j.next.next;
            i = i.next;
            if (i == j) return true;
        }

        return false;
    }
}
