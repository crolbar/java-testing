package leetcode.LL;
import java.util.ArrayList;

import leetcode.lib.*;

public
class _138
{
  public
    Node copyRandomList(Node head)
    {
        Node newHead = new Node(head.val);

        Node headCurr = head;
        Node newHeadCurr = newHead;

        while (headCurr.next != null) {
            newHeadCurr.next = new Node(headCurr.next.val);

            headCurr = headCurr.next;
            newHeadCurr = newHeadCurr.next;
        }

        int size = 0;

        ArrayList<Node> list = new ArrayList<>();

        newHeadCurr = newHead;
        while (newHeadCurr != null) {
            size++;

            list.add(newHeadCurr);
            newHeadCurr = newHeadCurr.next;
        }

        newHeadCurr = newHead;
        headCurr = head;

        while (newHeadCurr != null) {
            int c = 0;
            Node randCurr = headCurr.random;
            while (randCurr != null) {
                c++;
                randCurr = randCurr.next;
            };

            int randIdx = size - c;

            //int randVal = (headCurr.random != null) ? headCurr.random.val : -1;
            //System.out.printf("randval: %d, randIdx: %d\n", randVal, randIdx);

            if (randIdx >= list.size()) {
                newHeadCurr.random = null;
            } else {
                if (randIdx == 0) {
                    newHeadCurr.random = list.get(randIdx);
                } else {
                    newHeadCurr.random = list.get(randIdx - 1).next;
                }
            }

            newHeadCurr = newHeadCurr.next;
            headCurr = headCurr.next;
        }

        return newHead;
    }
}
