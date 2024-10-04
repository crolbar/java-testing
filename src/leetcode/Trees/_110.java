package leetcode.Trees;
import leetcode.lib.*;

public
class _110
{
  private
    int r(TreeNode root)
    {
        if (root == null)
            return 0;

        int l = r(root.left);
        int r = r(root.right);

        if (l == -1 || r == -1)
            return -1;

        if ((Math.max(l, r) - Math.min(l, r)) > 1)
            return -1;

        return Math.max(l, r) + 1;
    }

  public
    boolean isBalanced(TreeNode root)
    {
        if (root == null)
            return true;

        return r(root) == -1 ? false : true;
    }
}
