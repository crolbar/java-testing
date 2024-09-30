package leetcode.LL;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import leetcode.lib.ListNode;

public
class _23Test
{
    _23 o;
    @BeforeEach
    void setup() {
        o = new _23();
    }

    @Test void test()
    {

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);
        ListNode[] lists = new ListNode[] {list1, list2, list3};

        ListNode res = o.mergeKLists(lists);

        ListNode ans = new ListNode(1);
        ans.next = new ListNode(1);
        ans.next.next = new ListNode(2);
        ans.next.next.next = new ListNode(3);
        ans.next.next.next.next = new ListNode(4);
        ans.next.next.next.next.next = new ListNode(4);
        ans.next.next.next.next.next.next = new ListNode(5);
        ans.next.next.next.next.next.next.next = new ListNode(6);

        ListNode resCurr = res;
        ListNode ansCurr = ans;
        int i = 0;
        while (i < 3) {
            ListNode curr = lists[i++];
            while (curr != null) {
                System.out.printf("curr: %d, ans: %d, res: %d\n", curr.val, ansCurr.val, resCurr.val);

                assertEquals(ans.val, resCurr.val);

                curr = curr.next;
                ansCurr = ansCurr.next;
                //resCurr = resCurr.next;
            }
        }
    }

    @Test void test2()
    {
        ListNode[] lists = new ListNode[0];


        ListNode res = o.mergeKLists(lists);

        assertEquals(res, null);
    }
}
