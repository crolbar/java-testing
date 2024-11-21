package leetcode.LL;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import leetcode.lib.*;

public
class _83Test
{
    _83 o = new _83();

    @Test void test()
    {
        ListNode list = new ListNode(1);
        list.next = new ListNode(1);
        list.next.next = new ListNode(2);

        ListNode ans = new ListNode(1);
        ans.next = new ListNode(2);

        ListNode res = o.deleteDuplicates(list);

        System.out.println("\n");

        ListNode resCurr = res;
        ListNode ansCurr = ans;
        while (resCurr != null) {
            System.out.printf("expected: %d, actual: %d\n", ansCurr.val, resCurr.val);

            assertEquals(ansCurr.val, resCurr.val);

            resCurr = resCurr.next;
            ansCurr = ansCurr.next;
        }
    }


    @Test void test2()
    {
        ListNode list = new ListNode(1);
        list.next = new ListNode(1);
        list.next.next = new ListNode(1);

        ListNode ans = new ListNode(1);

        ListNode res = o.deleteDuplicates(list);

        System.out.println("\n");

        ListNode resCurr = res;
        ListNode ansCurr = ans;
        while (resCurr != null) {
            System.out.printf("expected: %d, actual: %d\n", ansCurr.val, resCurr.val);

            assertEquals(ansCurr.val, resCurr.val);

            resCurr = resCurr.next;
            ansCurr = ansCurr.next;
        }
    }
}
