package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _78 {
    void r(int[] nums, ArrayList<List<Integer>> res, ArrayList<Integer> list, int i) {
        if (i >= nums.length)
            return;

        list.add(nums[i]);

        res.add(list);

        while (i < nums.length) {
            r(nums, res, new ArrayList<>(list), ++i);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        int i = 0;
        while (i < nums.length) {
            r(nums, res, new ArrayList<>(), i++);
        }

        System.out.println(res);

        return res;
    }
}
