package leetcode.Trees;
import leetcode.lib.TreeNode;

public
class _572
{
  public
    boolean isSameTree(TreeNode p, TreeNode q)
    {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        if (p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

  public
    boolean isSubtree(TreeNode root, TreeNode subRoot)
    {
        if (root == null)
            return false;

        if (root.val == subRoot.val && isSameTree(root, subRoot))
            return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
