package leetcode.Trees;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import leetcode.lib.TreeNode;

public
class _235Test
{
    _235 o;
    @BeforeEach void setup() { o = new _235(); }

    @Test
    void test() {
        TreeNode root = new TreeNode(6);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);

        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.left = new TreeNode(3);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        Integer[] bfs = TreeNode.getBFS(root);


        TreeNode lca = o.lowestCommonAncestor(root, root.left, root.right);

        assertEquals(lca, root);

        System.out.println(Arrays.toString(bfs));
    }

    @Test
    void test2() {
        TreeNode root = new TreeNode(6);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);

        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.left = new TreeNode(3);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        Integer[] bfs = TreeNode.getBFS(root);


        TreeNode lca = o.lowestCommonAncestor(root, root.left.right.left, root.left.right.right);

        assertEquals(lca, root.left.right);

        System.out.println(Arrays.toString(bfs));
    }
}
