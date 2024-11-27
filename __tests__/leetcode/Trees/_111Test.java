package leetcode.Trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import leetcode.lib.TreeNode;

public
class _111Test
{
    _111 o = new _111();

    @Test void test()
    {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(Arrays.toString(TreeNode.getBFS(root)));

        var res = o.minDepth(root);

        System.out.println(res);
        assertEquals(2, res);
    }

    @Test void test2()
    {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(15);
        root.right.right.right = new TreeNode(7);
        root.right.right.right.right = new TreeNode(7);

        System.out.println(Arrays.toString(TreeNode.getBFS(root)));

        var res = o.minDepth(root);

        System.out.println(res);
        assertEquals(5, res);
    }

    @Test void test3()
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(Arrays.toString(TreeNode.getBFS(root)));

        var res = o.minDepth(root);

        System.out.println(res);
        assertEquals(2, res);
    }
}
