package leetcode.LL;
import leetcode.lib.ListNode;

public
class _25
{
    ListNode r(ListNode curr, ListNode prev, int k, int c)
    {
        if (curr == null || k == c)
            return prev;

        ListNode next = curr.next;
        curr.next = prev;

        return r(next, curr, k, c + 1);
    }

  private
    ListNode getKth(ListNode curr, int k)
    {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }

        return curr;
    }

  public
    ListNode reverseKGroup(ListNode head, int k)
    {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while (true) {
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) {
                break;
            }
            ListNode groupNext = kth.next;

            ListNode prev = kth.next;
            ListNode curr = groupPrev.next;
            while (curr != groupNext) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }

        return dummy.next;
    }
}
