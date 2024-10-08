package leetcode.Trees;
import leetcode.lib.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _230Test {
    _230 o;
    @BeforeEach void setup() { o = new _230(); }

    @Test void test()
    {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        root.right = new TreeNode(4);

        Integer[] bfs = TreeNode.getBFS(root);
        System.out.println(Arrays.toString(bfs));

        assertEquals(o.kthSmallest(root, 1), 1);
    }

    @Test void test1()
    {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);

        root.right = new TreeNode(6);

        Integer[] bfs = TreeNode.getBFS(root);
        System.out.println(Arrays.toString(bfs));

        assertEquals(o.kthSmallest(root, 3), 3);
    }
}
