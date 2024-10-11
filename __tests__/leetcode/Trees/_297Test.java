package leetcode.Trees;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import leetcode.lib.TreeNode;

public
class _297Test
{
    _297 o;
    @BeforeEach void setup() { o = new _297(); }

    @Test void test()
    {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(Arrays.toString(TreeNode.getBFS(root)));
        System.out.println(Arrays.toString(TreeNode.getPreDFS(root)));

        String ser = o.serialize(root);

        System.out.println();
        System.out.printf("[RES]: %s\n", ser);

        System.out.println();

        TreeNode de = o.deserialize(ser);
        System.out.println();

        System.out.println(Arrays.toString(TreeNode.getBFS(de)));
    }

    @Test void test1()
    {
        TreeNode root = null;

        String ser = o.serialize(root);

        System.out.println();
        System.out.printf("[RES]: %s\n", ser);

        System.out.println();

        TreeNode de = o.deserialize(ser);
        System.out.println();

        System.out.println(Arrays.toString(TreeNode.getBFS(de)));
    }

    @Test void test2()
    {
        TreeNode root = new TreeNode(-10);

        String ser = o.serialize(root);

        System.out.println();
        System.out.printf("[RES]: %s\n", ser);

        System.out.println();

        TreeNode de = o.deserialize(ser);
        System.out.println();

        System.out.println(Arrays.toString(TreeNode.getBFS(de)));
    }
}
