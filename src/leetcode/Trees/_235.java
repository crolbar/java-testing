package leetcode.Trees;

import leetcode.lib.TreeNode;

public
class _235
{
  public
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        while (true) {
            if (root.val > p.val && root.val < q.val)
                return root;

            if (root.val < p.val && root.val > q.val)
                return root;

            if (root.val == p.val || root.val == q.val)
                return root;

            // both are on the left side
            if (root.val > p.val && root.val > q.val)
                root = root.left;

            // both are on the right side
            if (root.val < p.val && root.val < q.val)
                root = root.right;
        }
    }
}
