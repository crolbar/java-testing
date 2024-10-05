package leetcode.Trees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.lib.TreeNode;

public
class _102
{
    class Pair
    {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level)
        {
            this.node = node;
            this.level = level;
        }
    }

    private void
    r(Queue<Pair> q, List<List<Integer>> list)
    {
        if (q.isEmpty())
            return;

        Pair curr = q.remove();

        if (list.size() - 1 < curr.level)
            list.add(new ArrayList<>());

        list.get(curr.level).add(curr.node.val);

        if (curr.node.left != null)
            q.add(new Pair(curr.node.left, curr.level + 1));

        if (curr.node.right != null)
            q.add(new Pair(curr.node.right, curr.level + 1));

        r(q, list);
    }

  public
    List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null)
            return list;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        r(q, list);

        return list;
    }
}
