package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class _46 {
    void r(int[] nums, List<List<Integer>> res, ArrayList<Integer> l, int bits) {
        if (Integer.bitCount(bits) == nums.length) {
            res.add(new ArrayList<>(l));
            return;
        }

        for (int i = 0, b = 1; i < nums.length; i++, b *= 2) {
            if ((bits & b) > 0)
                continue;

            l.add(nums[i]);
            r(nums, res, l, bits | b);
            l.removeLast();
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        r(nums, res, new ArrayList<>(), 0);

        return res;
    }
}
