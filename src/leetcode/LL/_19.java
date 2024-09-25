package leetcode.LL;
import leetcode.lib.*;

public
class _19
{
  public
    static void main()
    {
        System.out.println("19\n\n");
        _19 m = new _19();

        {
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);

            // ListNode head = new ListNode(1);
            // head.next = new ListNode(2);

            ListNode corr = new ListNode(1);
            corr.next = new ListNode(2);
            corr.next.next = new ListNode(3);
            corr.next.next.next = new ListNode(5);

            // ListNode corr = new ListNode(2);

            head = m.removeNthFromEnd(head, 2);

            ListNode curr = head;
            ListNode curr2 = corr;

            while (curr != null) {
                System.out.println(curr.val);

                assert curr.val == curr2.val;

                curr = curr.next;
                curr2 = curr2.next;
            }
        }
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
