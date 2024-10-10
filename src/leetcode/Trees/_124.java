package leetcode.Trees;

import leetcode.lib.TreeNode;

public
class _124
{
    int dfs(TreeNode curr, int[] max) {
        if (curr == null)
            return 0;

        int l = Math.max(dfs(curr.left, max), 0);
        int r = Math.max(dfs(curr.right, max), 0);

        max[0] = Math.max(max[0], r + l + curr.val);
        return curr.val + Math.max(l, r);
    }

  public
    int maxPathSum(TreeNode root)
    {
        int[] max = new int[]{ root.val };
        dfs(root, max);
        return max[0];
    }
}
