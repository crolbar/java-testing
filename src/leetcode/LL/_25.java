package leetcode.LL;
import leetcode.lib.ListNode;

public
class _25
{
  private
    ListNode reverse(ListNode curr, ListNode prev, ListNode groupNext)
    {
        if (curr == groupNext)
            return prev;

        ListNode next = curr.next;
        curr.next = prev;

        return reverse(next, curr, groupNext);
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

  private
    void r(ListNode groupPrev, int k)
    {
        ListNode kth = getKth(groupPrev, k);
        if (kth == null)
            return;

        ListNode groupNext = kth.next;

        ListNode tmp = groupPrev.next;

        groupPrev.next = this.reverse(groupPrev.next, groupNext, groupNext);

        r(tmp, k);
    }

  public
    ListNode reverseKGroup(ListNode head, int k)
    {
        ListNode dummy = new ListNode(0, head);

        r(dummy, k);

        return dummy.next;
    }
}
