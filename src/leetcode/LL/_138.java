package leetcode.LL;
import java.util.HashMap;

import leetcode.lib.*;

public
class _138
{
  public
    Node copyRandomList(Node head)
    {
        if (head == null)
            return null;

        HashMap<Node, Node> list = new HashMap<>();

        Node headCurr = head;
        while (headCurr != null) {
            list.put(headCurr, new Node(headCurr.val));
            headCurr = headCurr.next;
        }

        headCurr = head;
        while (headCurr != null) {
            Node currNode = list.get(headCurr);

            if (!list.containsKey(headCurr.random)) {
                currNode.random = null;
            } else {
                currNode.random = list.get(headCurr.random);
            }

            if (!list.containsKey(headCurr.next)) {
                currNode.next = null;
            } else {
                currNode.next = list.get(headCurr.next);
            }

            headCurr = headCurr.next;
        }

        return list.get(head);
    }
}
