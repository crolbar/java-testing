package leetcode.Trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import leetcode.lib.TreeNode;

public
class _108Test
{
    _108 o = new _108();

    @Test void test()
    {
        TreeNode root = new TreeNode(0);

        root.left = new TreeNode(-3);
        root.left.left = new TreeNode(-10);

        root.right = new TreeNode(9);
        root.right.left = new TreeNode(5);

        Integer[] correct_bfs = TreeNode.getBFS(root);

        System.out.println("[BFS]: " + Arrays.toString(correct_bfs));
        System.out.println();



        var res = o.sortedArrayToBST(new int[]{ -10,-3,0,5,9 });


        System.out.println();
        System.out.println("[RES BFS]: " + Arrays.toString(TreeNode.getBFS(res)));
    }
}
