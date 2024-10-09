package leetcode.Trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import leetcode.lib.TreeNode;

public
class _105Test
{
    _105 o;
    @BeforeEach void setup() { o = new _105(); }

    @Test void test()
    {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Integer[] bfs = TreeNode.getBFS(root);

        System.out.println("[BFS]: " + Arrays.toString(bfs));

        System.out.println("[DFS Pre]: " +
                           Arrays.toString(TreeNode.getPreDFS(root)));
        System.out.println("[DFS In]: " +
                           Arrays.toString(TreeNode.getInDFS(root)));

        System.out.println();

        bfs = TreeNode.getBFS(o.buildTree(new int[]{ 3, 9, 20, 15, 7 },
                                          new int[]{ 9, 3, 15, 20, 7 }));

        System.out.println();

        System.out.println("[RES BFS]: " + Arrays.toString(bfs));
    }

    @Test void test2()
    {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.left.right = new TreeNode(8);
        root.left.left = new TreeNode(7);
        root.left.left.left = new TreeNode(4);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(6);

        Integer[] bfs = TreeNode.getBFS(root);

        System.out.println("[BFS]: " + Arrays.toString(bfs));

        System.out.println("[DFS Pre]: " +
                           Arrays.toString(TreeNode.getPreDFS(root)));
        System.out.println("[DFS In]: " +
                           Arrays.toString(TreeNode.getInDFS(root)));

        System.out.println();

        bfs =
          TreeNode.getBFS(o.buildTree(new int[]{ 3, 9, 7, 4, 8, 20, 15, 6 },
                                      new int[]{ 4, 7, 9, 8, 3, 15, 20, 6 }));

        System.out.println();

        System.out.println("[RES BFS]: " + Arrays.toString(bfs));
    }
}
