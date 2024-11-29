package leetcode.DP;

public
class _746
{
  public
    int minCostClimbingStairs(int[] cost)
    {
        int[] minCosts = new int[cost.length];

        minCosts[0] = cost[0];
        minCosts[1] = cost[1];

        for (int i = 2; i < cost.length; i++)
            minCosts[i] = cost[i] + Math.min(minCosts[i - 1], minCosts[i - 2]);

        return Math.min(minCosts[cost.length - 1], minCosts[cost.length - 2]);
    }
}
