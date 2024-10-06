package leetcode.Trees;
import leetcode.lib.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _1448Test {
    _1448 o;
    @BeforeEach void setup() { o = new _1448(); }

    @Test void test()
    {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);

        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        Integer[] bfs = TreeNode.getBFS(root);
        System.out.println(Arrays.toString(bfs));

        assertEquals(o.goodNodes(root), 4);
    }

    @Test void test2()
    {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(2);


        Integer[] bfs = TreeNode.getBFS(root);
        System.out.println(Arrays.toString(bfs));

        assertEquals(o.goodNodes(root), 3);
    }
}
