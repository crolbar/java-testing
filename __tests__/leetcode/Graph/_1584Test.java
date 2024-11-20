package leetcode.Graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public
class _1584Test
{
    _1584 o = new _1584();

    @Test void test()
    {
        var res = o.minCostConnectPoints(
          new int[][]{ { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } });

        System.out.println(res);
        //assertEquals(20, res);
    }
}
