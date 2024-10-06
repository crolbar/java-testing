package leetcode.Trees;
import java.util.ArrayList;
import java.util.List;

import leetcode.lib.*;

public
class _199
{
    void r(TreeNode curr, List<Integer> l, int c) {
        if (curr == null)
            return;
        c++;

        if (c - 1 >= l.size()) {
            l.add(curr.val);
        }

        r(curr.right, l, c);
        r(curr.left, l, c);
    }

  public
    List<Integer> rightSideView(TreeNode root)
    {
        List<Integer> l = new ArrayList<>();

        r(root, l, 0);

        return l;
    }
}
