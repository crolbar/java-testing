package leetcode.Trees;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import leetcode.lib.*;

public
class _102Test
{
    _102 o;
    @BeforeEach void setup() { o = new _102(); }
    @Test void test()
    {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> l = o.levelOrder(root);

        System.out.println(l.toString());
    }
}
