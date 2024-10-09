package leetcode.Trees;

import java.util.HashMap;

import leetcode.lib.TreeNode;

public
class _105
{

    // private
    //   int getIdx(int needle, int[] haystack, int l, int r)
    //   {
    //       for (int i = l; i < r; i++) {
    //           if (haystack[i] == needle)
    //               return i;
    //       }
    //       return -1;
    //   }

    void r(TreeNode currRoot,
           HashMap<Integer, Integer> inorderMap,
           int[] preorder,
           int[] preorderIdx,
           int l,
           int r)
    {

        if (preorderIdx[0] >= preorder.length)
            return;

        if (l >= r)
            return;

        int nextNodeVal = preorder[preorderIdx[0]];
        preorderIdx[0]++;
        TreeNode nextNode = new TreeNode(nextNodeVal);

        int currRootIdx = inorderMap.get(currRoot.val);
        int nextNodeIdx = inorderMap.get(nextNode.val);

        if (nextNodeIdx >= r || nextNodeIdx < l) {
            preorderIdx[0]--;
            return;
        }

        System.out.printf("currRoot: %d, currRootIdx: %d, nextNode: %d, " +
                            "nextNodeIdx: %d, l: %d, r: %d\n",
                          currRoot.val,
                          currRootIdx,
                          nextNode.val,
                          nextNodeIdx,
                          l,
                          r);

        if (nextNodeIdx < currRootIdx) { // left
            currRoot.left = nextNode;
            r(currRoot.left, inorderMap, preorder, preorderIdx, l, currRootIdx);

        } else { // right
            currRoot.right = nextNode;
            r(currRoot.right,
              inorderMap,
              preorder,
              preorderIdx,
              currRootIdx + 1,
              r); // l is an index so + 1
        }

        r(currRoot, inorderMap, preorder, preorderIdx, l, r);
    }

  public
    TreeNode buildTree(int[] preorder, int[] inorder)
    {
        TreeNode root = new TreeNode(preorder[0]);

        HashMap<Integer, Integer> inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        r(root, inorderMap, preorder, new int[]{ 1 }, 0, inorder.length);

        return root;
    }
}
