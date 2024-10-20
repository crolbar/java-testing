package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class _39 {
    void r(int[] nums, int target, List<List<Integer>> res, ArrayList<Integer> list, int i) {

        list.add(nums[i]);

        target -= nums[i];

        if (i > nums.length) {
            list.removeLast();
            return;
        }

        if (target < 0) {
            list.removeLast();
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(list));
            list.removeLast();
            return;
        }

        while (i < nums.length) {
            System.out.printf("i: %d, target(%d) - nums[i](%d): %d, list: %s\n", i, target, nums[i], target - nums[i], list.toString());

            r(nums, target, res, list, i);

            i++;
        }

        list.removeLast();
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            r(candidates, target, res, l, i);
        }
        return res;
    }
}
