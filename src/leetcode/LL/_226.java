package leetcode.LL;
import leetcode.lib.TreeNode;

public
class _226
{
  private
    void r(TreeNode curr)
    {
        if (curr == null)
            return;

        TreeNode tmp = curr.left;
        curr.left = curr.right;
        curr.right = tmp;

        r(curr.left);
        r(curr.right);
    }

  public
    TreeNode invertTree(TreeNode root)
    {
        r(root);
        return root;
    }
}
