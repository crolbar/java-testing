package leetcode.Trees;

import java.util.HashMap;

import leetcode.lib.TreeNode;

public
class _105
{
    TreeNode r(HashMap<Integer, Integer> inorderMap,
               int[] preorder,
               int[] preorderIdx,
               int r)
    {
        if (preorderIdx[0] >= preorder.length)
            return null;

        TreeNode root = new TreeNode(preorder[preorderIdx[0]]);

        int rootIdx = inorderMap.get(root.val);

        System.out.printf(
          "root: %d, rootIdx: %d, r: %d\n", root.val, rootIdx, r);

        if (rootIdx >= r)
            return null;

        preorderIdx[0]++;

        root.left = r(inorderMap, preorder, preorderIdx, rootIdx);
        root.right = r(inorderMap, preorder, preorderIdx, r);

        return root;
    }

  public
    TreeNode buildTree(int[] preorder, int[] inorder)
    {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inorderMap.put(inorder[i], i);

        return r(inorderMap, preorder, new int[]{ 0 }, inorder.length);
    }
}
