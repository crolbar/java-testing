package leetcode.LL;
import leetcode.lib.*;

import org.junit.jupiter.api.Test;

public
class _19Test
{
    @Test public void test1()
    {
        _19 m = new _19();

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

    @Test public void test2()
    {
        _19 m = new _19();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        ListNode corr = new ListNode(2);

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
