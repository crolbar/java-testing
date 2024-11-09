package leetcode.Trees;

import java.util.LinkedList;

import leetcode.lib.*;

public
class _101
{
    boolean bfs(LinkedList<TreeNode> ll)
    {
        if (ll.isEmpty())
            return true;

        LinkedList<TreeNode> llClone = new LinkedList<>(ll);
        ll.clear();

        while (!llClone.isEmpty()) {
            TreeNode first = llClone.pollFirst();
            TreeNode last = llClone.pollLast();

            if (first == null && last == null) {
                continue;
            }

            if (first == null || last == null) {
                return false;
            }

            if (first.val != last.val)
                return false;

            ll.addFirst(first.left);
            ll.addFirst(first.right);

            ll.addLast(last.right);
            ll.addLast(last.left);
        }

        if (!bfs(ll))
            return false;
        return true;
    }

  public
    boolean isSymmetric(TreeNode root)
    {
        LinkedList<TreeNode> ll = new LinkedList<>();
        ll.add(root.left);
        ll.add(root.right);

        return bfs(ll);
    }
}
