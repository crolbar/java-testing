package leetcode.DP;

public class _62
{
    private int r(int[] source, int[] target, int[][] memo)
    {
        // out of bounds
        if (source[0] > target[0])
            return 0;
        if (source[1] > target[1])
            return 0;

        // got to target
        if (source[0] == target[0] && source[1] == target[1])
            return 1;

        if (memo[source[0]][source[1]] > 0)
            return memo[source[0]][source[1]];

        int n = 0;
        n += r(new int[] { source[0] + 1, source[1] }, target, memo);
        n += r(new int[] { source[0], source[1] + 1 }, target, memo);

        memo[source[0]][source[1]] = n;

        return n;
    }

    public int uniquePaths(int m, int n)
    {
        return r(new int[] { 0, 0 }, new int[] { m - 1, n - 1 }, new int[m][n]);
    }
}
