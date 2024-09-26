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

class _19_2
{
  public
    ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode t = new ListNode(0, head);
        ListNode l = t;
        ListNode r = head;

        while (n > 0) {
            r = r.next;
            n--;
        }

        while (r != null) {
            l = l.next;
            r = r.next;
        }

        l.next = l.next.next;
        return t.next;
    }
}
