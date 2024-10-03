package leetcode.LL;
import leetcode.lib.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _543Test
{
    _543 o;
    @BeforeEach void setup() { o = new _543(); }
    @Test void test() {
        
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right = new TreeNode(3);

        Integer[] bfs = TreeNode.getBFS(root);
        System.out.println(Arrays.toString(bfs));
        int diameter = o.diameterOfBinaryTree(root);

        System.out.println(diameter);

        assertEquals(diameter, 3);
    }
}
