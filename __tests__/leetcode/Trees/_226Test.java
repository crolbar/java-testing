package leetcode.Trees;

import leetcode.lib.TreeNode;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _226Test
{
    _226 o;
    @BeforeEach void setup() { o = new _226(); }

    @Test void test()
    {
        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println(Arrays.toString(TreeNode.getDFS(root)));

        o.invertTree(root);

        System.out.println(Arrays.toString(TreeNode.getDFS(root)));
    }
}
