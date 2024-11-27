package leetcode.Trees;
import java.util.Queue;
import java.util.LinkedList;
import leetcode.lib.*;

public
class _111
{
    class Pair
    {
        TreeNode node;
        int depth;
      public
        Pair(TreeNode n, int d)
        {
            this.node = n;
            this.depth = d;
        }
    }

    public int
    minDepth(TreeNode root)
    {
        if (root == null)
            return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 1));

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            if (curr.node == null)
                continue;

            if (curr.node.left == null && curr.node.right == null)
                return curr.depth;

            q.offer(new Pair(curr.node.left, curr.depth + 1));
            q.offer(new Pair(curr.node.right, curr.depth + 1));
        }

        return 0;
    }
}
