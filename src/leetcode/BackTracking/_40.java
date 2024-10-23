package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public
class _40
{
    void r(int[] candidates,
           List<List<Integer>> res,
           ArrayList<Integer> l,
           int target,
           int i)
    {
        if (target < 0)
            return;

        if (target == 0) {
            res.add(new ArrayList<>(l));
            return;
        }

        
        for (int start = i; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue;

            l.add(candidates[i]);
            r(candidates, res, l, target - candidates[i], i + 1);
            l.removeLast();
        }
    }

  public
    List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        r(candidates, res, new ArrayList<>(), target, 0);
        return res;
    }
}
