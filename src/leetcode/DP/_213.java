package leetcode.DP;

import java.util.Arrays;

public
class _213
{
  public
    int rob(int[] nums)
    {
        int n = nums.length;
        if (n == 1)
            return nums[0];

        int f = h(Arrays.copyOfRange(nums, 0, n - 1));
        int u = h(Arrays.copyOfRange(nums, 1, n));
        return Math.max(f, u);
    }

    private int h(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);

        for (int i = 2; i < nums.length; i++)
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);

        return dp[nums.length - 1];
    }
}
