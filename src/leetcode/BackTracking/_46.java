package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _46 {
    void r(int[] nums, List<List<Integer>> res, ArrayList<Integer> l, HashSet<Integer> set) {
        if (l.size() == nums.length) {
            res.add(new ArrayList<>(l));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                continue;


            l.add(nums[i]);
            set.add(nums[i]);

            r(nums, res, l, set);

            set.remove(nums[i]);
            l.removeLast();
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        r(nums, res, new ArrayList<>(), new HashSet<>());

        return res;
    }
}
