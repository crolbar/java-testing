package leetcode.LL;
import leetcode.lib.*;

public
class _2
{
  public
    ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode res = new ListNode();

        ListNode currRes = res;
        int carry = 0;
        while ((l1 != null || l2 != null) || carry == 1) {
            int num1 = (l1 != null) ? l1.val : 0;
            int num2 = (l2 != null) ? l2.val : 0;

            int sum = num1 + num2 + carry;
            carry = sum / 10;

            currRes.next = new ListNode(sum % 10);

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
            currRes = currRes.next;
        }

        return res.next;
    }
}
