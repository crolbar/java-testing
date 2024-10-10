package leetcode.Trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import leetcode.lib.TreeNode;

public
class _124Test
{
    _124 o;
    @BeforeEach void setup() { o = new _124(); }

    @Test void test()
    {
        TreeNode root = new TreeNode(-10);

        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int r = o.maxPathSum(root);

        System.out.println(r);

        assertEquals(r, 42);
    }

    @Test void test2()
    {
        TreeNode root = new TreeNode(-3);
        int r = o.maxPathSum(root);
        System.out.println(r);
        assertEquals(r, -3);
    }

    @Test void test3()
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        int r = o.maxPathSum(root);
        System.out.println(r);
        assertEquals(r, 3);
    }

    @Test void test4()
    {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);
        int r = o.maxPathSum(root);
        System.out.println(r);
        assertEquals(r, 2);
    }

    @Test void test5()
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(3);
        int r = o.maxPathSum(root);
        System.out.println(r);
        assertEquals(r, 4);
    }
}
