package leetcode.Trees;

import leetcode.lib.TreeNode;

public
class _108
{
    TreeNode dfs(int[] nums, int l, int r)
    {
        if (l > r)
            return null;

        if (r < 0 || r >= nums.length)
            return null;

        if (l < 0 || l >= nums.length)
            return null;

        int m = l + (r - l) / 2;

        TreeNode n = new TreeNode(nums[m]);

        n.left = dfs(nums, l, m - 1);
        n.right = dfs(nums, m + 1, r);

        return n;
    }

  public
    TreeNode sortedArrayToBST(int[] nums)
    {
        return dfs(nums, 0, nums.length - 1);
    }
}
