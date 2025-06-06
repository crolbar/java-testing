package leetcode.DP;

import java.util.Arrays;

public
class _300
{
  public
    int lengthOfLIS(int[] nums)
    {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = nums.length - 1; i >= 0; i--)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] < nums[j])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);

        System.out.println(Arrays.toString(dp));

        int res = 0;

        for (int i = 0; i < dp.length; i++)
            res = Math.max(res, dp[i]);

        return res;
    }
}
