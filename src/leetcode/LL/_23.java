package leetcode.LL;
import java.util.ArrayList;

import leetcode.lib.ListNode;

public
class _23
{
    ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        if (list1 == null || list2 == null) {
            if (list1 == null && list2 == null)
                return null;
            return (list1 != null) ? list1 : list2;
        }

        ListNode res = new ListNode();

        if (list1.val < list2.val) {
            res.val = list1.val;
            list1 = list1.next;
        } else {
            res.val = list2.val;
            list2 = list2.next;
        }

        res.next = mergeTwoLists(list1, list2);

        return res;
    }

  public
    ListNode mergeKLists(ListNode[] lists)
    {
        if (lists.length <= 0)
            return null;

        if (lists.length == 1)
            return lists[0];

        ArrayList<ListNode> mergedLists = new ArrayList<ListNode>();

        for (int i = 0; i < lists.length; i += 2) {
            ListNode l1 = lists[i];
            ListNode l2 = (i + 1 >= lists.length) ? null : lists[i + 1];

            mergedLists.add(this.mergeTwoLists(l1, l2));
        }

        lists = mergedLists.toArray(new ListNode[0]);

        return mergeKLists(lists);
    }
}
