package leetcode.DP;
import org.junit.jupiter.api.Test;

public
class _746Test
{
    _746 o = new _746();

    @Test void test()
    {
        var res = o.minCostClimbingStairs(new int[]{ 10, 15, 20 });
        System.out.println(res);
    }

    @Test void test2()
    {
        var res = o.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1});
        System.out.println(res);
    }
}
