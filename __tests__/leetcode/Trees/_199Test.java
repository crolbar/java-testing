package leetcode.Trees;
import leetcode.lib.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _199Test
{
    _199 o;
    @BeforeEach void setup() { o = new _199(); }

    @Test void test()
    {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);

        Integer[] bfs = TreeNode.getBFS(root);
        System.out.println(Arrays.toString(bfs));

        assertArrayEquals(o.rightSideView(root).stream().mapToInt(Integer::intValue).toArray(), new int[]{ 1, 3, 4 });
    }

    @Test void test2()
    {
        TreeNode root = new TreeNode(1);

        root.right = new TreeNode(3);


        Integer[] bfs = TreeNode.getBFS(root);
        System.out.println(Arrays.toString(bfs));

        assertArrayEquals(o.rightSideView(root).stream().mapToInt(Integer::intValue).toArray(), new int[]{ 1, 3 });
    }

    @Test void test3()
    {
        TreeNode root = new TreeNode(1);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(4);

        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.left.left.left.right = new TreeNode(8);


        Integer[] bfs = TreeNode.getBFS(root);
        System.out.println(Arrays.toString(bfs));

        assertArrayEquals(o.rightSideView(root).stream().mapToInt(Integer::intValue).toArray(), new int[]{ 1, 2, 3, 4, 8 });
    }
}
