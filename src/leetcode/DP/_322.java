package leetcode.DP;

import java.util.Arrays;

public
class _322
{
  public
    int coinChange(int[] coins, int amount)
    {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++)
            for (int j = 0; j < coins.length; j++)
                if (coins[j] <= i)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);

        System.out.println(Arrays.toString(dp));

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
