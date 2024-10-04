package leetcode.Trees;
import leetcode.lib.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _110Test
{
    _110 o;
    @BeforeEach void setup() { o = new _110(); }

    @Test
    void test() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);


        Integer[] bfs = TreeNode.getBFS(root);

        System.out.println(Arrays.toString(bfs));

        assertEquals(o.isBalanced(root), true);
    }

    @Test
    void test2() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(5);


        Integer[] bfs = TreeNode.getBFS(root);

        System.out.println(Arrays.toString(bfs));

        assertEquals(o.isBalanced(root), false);
    }
}
