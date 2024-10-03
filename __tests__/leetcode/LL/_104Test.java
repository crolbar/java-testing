package leetcode.LL;
import leetcode.lib.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _104Test
{
    _104 o;
    @BeforeEach void setup() { o = new _104(); }
    @Test void test() {
        
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Integer[] bfs = TreeNode.getBFS(root);
        System.out.println(Arrays.toString(bfs));
        int depth = o.maxDepth(root);

        System.out.println(depth);

        assertEquals(depth, 3);
    }
}
