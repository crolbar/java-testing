package leetcode.Trees;
import leetcode.lib.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _98Test {
    _98 o;
    @BeforeEach void setup() { o = new _98(); }

    @Test void test()
    {
        TreeNode root = new TreeNode(2);

        root.left = new TreeNode(1);

        root.right = new TreeNode(3);

        Integer[] bfs = TreeNode.getBFS(root);
        System.out.println(Arrays.toString(bfs));

        assertEquals(o.isValidBST(root), true);
    }

    @Test void test2()
    {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(1);

        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(3);

        Integer[] bfs = TreeNode.getBFS(root);
        System.out.println(Arrays.toString(bfs));

        assertEquals(o.isValidBST(root), false);
    }

    @Test void test3()
    {
        TreeNode root = new TreeNode(10);

        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(7);
        root.left.left.right.left = new TreeNode(6);
        root.left.left.right.right = new TreeNode(8);

        root.right = new TreeNode(11);

        root.right.right = new TreeNode(13);

        root.right.right.left = new TreeNode(12);
        root.right.right.right = new TreeNode(14);

        root.right.right.right.right = new TreeNode(17);
        root.right.right.right.right.left = new TreeNode(16);
        root.right.right.right.right.left.left = new TreeNode(15);

        Integer[] bfs = TreeNode.getBFS(root);
        System.out.println(Arrays.toString(bfs));

        assertEquals(o.isValidBST(root), true);
    }
}
