package leetcode.Trees;
import leetcode.lib.*;

public
class _1448
{
    void r(TreeNode curr, int[] c, int max)
    {
        if (curr == null)
            return;

        if (max <= curr.val) {
            max = curr.val;
            c[0]++;
        }

        r(curr.left, c, max);
        r(curr.right, c, max);
    }

  public
    int goodNodes(TreeNode root)
    {
        int[] c = new int[]{ 0 };

        r(root, c, Integer.MIN_VALUE);

        return c[0];
    }
}
