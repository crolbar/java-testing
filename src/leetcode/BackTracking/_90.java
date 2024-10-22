package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90 {
    ArrayList<Integer> get(int[] nums, int bits) {
        ArrayList<Integer> l = new ArrayList<>();

        for (int i = 0, b = 1; b <= bits; i++, b *= 2) {
            if ((bits & b) > 0) {
                l.add(nums[i]);
            }
        }

        return l;
    }

    void r(int[] nums, ArrayList<List<Integer>> res, int bits, int i) {
        if (i > nums.length)
            return;

        res.add(get(nums, bits));

        double b = (bits == 0) ? 0.5 : Integer.highestOneBit(bits);

        for (int j = i; j < nums.length; j++, b *= 2) {
            if (j > i && nums[j] == nums[j - 1])
                continue;

            r(nums, res, bits | (int)(b * 2), j + 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        r(nums, res, 0, 0);

        return res;
    }
}
