package leetcode.LL;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import leetcode.lib.Node;

public
class _138Test
{
    @Test void test1()
    {
        _138 o = new _138();

        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        Node res = o.copyRandomList(head);

        Node curr = head;
        Node resCurr = res;
        while (resCurr != null) {
            int randVal = (curr.random != null) ? curr.random.val : -1;

            int nextVal = (curr.next != null) ? curr.next.val : -1;
            System.out.printf(
              "curr: %d, rand: %d, next: %d\n", curr.val, randVal, nextVal);

            int randVal2 = (resCurr.random != null) ? resCurr.random.val : -1;
            int randRandVal2 =
              (resCurr.random != null && resCurr.random.random != null)
                ? resCurr.random.random.val
                : -1;

            int nextVal2 = (resCurr.next != null) ? resCurr.next.val : -1;
            System.out.printf("resCurr: %d, rand: %d, randrand: %d, next: %d\n",
                              resCurr.val,
                              randVal2,
                              randRandVal2,
                              nextVal2);

            assertEquals(curr.val, resCurr.val);
            assertEquals(randVal, randVal2);
            assertEquals(nextVal, nextVal2);

            curr = curr.next;
            resCurr = resCurr.next;
        }
    }
}
