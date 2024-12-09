package leetcode.DP;

import java.util.Arrays;

public
class _300
{
  private
    int dfs(int[] nums, int prevI, int i, int[] memo)
    {
        if (i >= nums.length)
            return 1;

        if (nums[prevI] >= nums[i])
            return dfs(nums, prevI, i + 1, memo);

        int countCurr =
          (memo[i] != -1) ? 1 + memo[i] : 1 + dfs(nums, i, i + 1, memo);

        int skipCurr = dfs(nums, prevI, i + 1, memo);

        int c = Math.max(countCurr, skipCurr);

        memo[prevI] = c;

        return c;
    }

  public
    int lengthOfLIS(int[] nums)
    {
        int res = 0;
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        for (int i = 0; i < nums.length; i++) {
            int c = dfs(nums, i, i + 1, memo);
            res = Math.max(res, c);
        }

        System.out.println(Arrays.toString(memo));

        return res;
    }
}
