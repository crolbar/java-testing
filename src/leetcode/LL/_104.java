package leetcode.LL;

import leetcode.lib.*;

public
class _104
{
  public
    int maxDepth(TreeNode root)
    {
        if (root == null)
            return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
