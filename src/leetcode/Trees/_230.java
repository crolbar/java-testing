package leetcode.Trees;

import leetcode.lib.TreeNode;

public
class _230
{

    int dfs(TreeNode curr, int[] k)
    {
        if (curr == null)
            return -1;

        int r = dfs(curr.left, k);

        if (r != -1)
            return r;

        if (k[0] == 1)
            return curr.val;

        k[0]--;

        return dfs(curr.right, k);
    }

  public
    int kthSmallest(TreeNode root, int k)
    {
        return dfs(root, new int[]{k});
    }
}
