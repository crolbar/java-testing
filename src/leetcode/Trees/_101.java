package leetcode.Trees;

import leetcode.lib.*;

public
class _101
{
    boolean dfs(TreeNode l, TreeNode r)
    {
        if (l == null && r == null)
            return true;

        if (l == null || r == null)
            return false;

        if (l.val != r.val)
            return false;

        return dfs(l.left, r.right) && dfs(l.right, r.left);
    }

  public
    boolean isSymmetric(TreeNode root) { return dfs(root.left, root.right); }
}
