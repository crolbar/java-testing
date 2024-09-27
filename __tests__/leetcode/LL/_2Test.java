package leetcode.LL;

import org.junit.jupiter.api.Test;

import leetcode.lib.ListNode;

public
class _2Test
{
    @Test void test1()
    {
        _2 o = new _2();

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode res = o.addTwoNumbers(l1, l2);

        ListNode ans = new ListNode(7);
        ans.next = new ListNode(0);
        ans.next.next = new ListNode(8);

        ListNode curr = res;
        ListNode currAns = ans;
        while (curr != null) {
            System.out.println(curr.val);
            assert curr.val == currAns.val;

            curr = curr.next;
            currAns = currAns.next;
        }
    }

    @Test void test2()
    {
        _2 o = new _2();

        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);

        ListNode res = o.addTwoNumbers(l1, l2);

        ListNode ans = new ListNode(8);
        ans.next = new ListNode(9);
        ans.next.next = new ListNode(9);
        ans.next.next.next = new ListNode(9);
        ans.next.next.next.next = new ListNode(0);
        ans.next.next.next.next.next = new ListNode(0);
        ans.next.next.next.next.next.next = new ListNode(0);
        ans.next.next.next.next.next.next.next = new ListNode(1);

        ListNode curr = res;
        ListNode currAns = ans;
        while (curr != null) {
            System.out.println(curr.val);
            assert curr.val == currAns.val;

            curr = curr.next;
            currAns = currAns.next;
        }
    }
}
