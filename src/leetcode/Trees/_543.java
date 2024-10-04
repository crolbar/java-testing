package leetcode.Trees;
import leetcode.lib.*;

public
class _543
{
  private
    int r(TreeNode curr, int[] max)
    {
        if (curr == null)
            return 0;

        int maxDepthL = r(curr.left, max);
        int maxDepthR = r(curr.right, max);

        max[0] = Math.max(max[0], maxDepthL + maxDepthR);

        return Math.max(maxDepthL, maxDepthR) + 1;
    }

  public
    int diameterOfBinaryTree(TreeNode root)
    {
        int[] max = new int[1];
        r(root, max);
        return max[0];
    }
}
