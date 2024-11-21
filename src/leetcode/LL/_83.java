package leetcode.LL;
import leetcode.lib.*;

public
class _83
{
    void r(ListNode curr)
    {
        if (curr == null || curr.next == null)
            return;

        while (curr.next != null && curr.val == curr.next.val) {
            curr.next = curr.next.next;
        }

        r(curr.next);
    }
  public
    ListNode deleteDuplicates(ListNode head)
    {
        r(head);
        return head;
    }
}
