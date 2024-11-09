package leetcode.Trees;
import org.junit.jupiter.api.Test;

import leetcode.lib.*;

public
class _101Test
{
    _101 o = new _101();

    @Test void test()
    {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        var res = o.isSymmetric(root);

        System.out.println(res);
    }

    @Test void test2()
    {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        var res = o.isSymmetric(root);

        System.out.println(res);
    }

    @Test void test3()
    {
        TreeNode root = new TreeNode(2);

        root.left = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);

        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(8);

        var res = o.isSymmetric(root);

        System.out.println(res);
    }
}
