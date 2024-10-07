package leetcode.Trees;
import leetcode.lib.*;

public
class _98
{
    boolean r(TreeNode curr, Integer min, Integer max) {
        if (curr == null)
            return true;

        if (min != null) {
            if (curr.val <= min) {
                return false;
            }
        }

        if (max != null) {
            if (curr.val >= max) {
                return false;
            }
        }

        if (r(curr.left, min, curr.val) && r(curr.right, curr.val, max)) {
            return true;
        }

        return false;
    }

    public boolean isValidBST(TreeNode root) {
        return r(root, null, null);
    }
}
