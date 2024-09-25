package leetcode.LL;
import leetcode.lib.*;

public
class _19
{
  public
    static void main(String[] args)
    {
        System.out.println("19");
        System.out.println("\n");
    }

    int r(ListNode curr, int n)
    {
        if (curr == null)
            return 1;

        int c = r(curr.next, n);

        if (c == 0)
            return 0;

        if (c == n + 1) {
            curr.next = curr.next.next;
            return 0;
        }

        return c + 1;
    }

  public
    ListNode removeNthFromEnd(ListNode head, int n)
    {
        if (r(head, n) != 0)
            head = head.next;

        return head;
    }
}
