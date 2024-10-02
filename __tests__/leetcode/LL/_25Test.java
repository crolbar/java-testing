package leetcode.LL;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import leetcode.lib.*;

public
class _25Test
{
    _25 o;
    @BeforeEach void setup() { o = new _25(); }

    @Test void test()
    {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        list.next.next.next.next.next = new ListNode(6);

        ListNode ans = new ListNode(3);
        ans.next = new ListNode(2);
        ans.next.next = new ListNode(1);
        ans.next.next.next = new ListNode(6);
        ans.next.next.next.next = new ListNode(5);
        ans.next.next.next.next.next = new ListNode(4);

        ListNode res = o.reverseKGroup(list, 3);

        System.out.println("\n");

        ListNode resCurr = res;
        ListNode ansCurr = ans;
        while (resCurr != null) {
            System.out.println(resCurr.val);
            assertEquals(ansCurr.val, resCurr.val);

            resCurr = resCurr.next;
            ansCurr = ansCurr.next;
        }
    }
}
