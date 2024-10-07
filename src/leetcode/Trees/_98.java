package leetcode.Trees;
import leetcode.lib.*;

public
class _98
{
    boolean r(TreeNode curr, Integer min, Integer max) {
        if (curr == null)
            return true;

        if (curr.left != null ) {
            if (curr.left.val >= curr.val) {
                return false;
            }
        }

        if (curr.right != null) {
            if (curr.right.val <= curr.val) {
                return false;
            }
        }

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

        int nextMax = (max == null) ? curr.val : Math.min(max, curr.val);
        int nextMin = (min == null) ? curr.val : Math.max(min, curr.val);


        // left min of max - right max of min
        if (r(curr.left, min, nextMax) && r(curr.right, nextMin, max)) {
            return true;
        }

        return false;
    }

    public boolean isValidBST(TreeNode root) {
        return r(root, null, null);
    }
}
