package leetcode.Graph;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public
class _210Test
{
    _210 o = new _210();

    @Test void test()
    {
        var res = o.findOrder(2, new int[][]{ { 0, 1 } });

        System.out.println(Arrays.toString(res));
    }

    @Test void test2()
    {
        var res =
          o.findOrder(4, new int[][]{ { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } });

        System.out.println(Arrays.toString(res));
    }

    @Test void test3()
    {
        var res = o.findOrder(1, new int[][]{});

        System.out.println(Arrays.toString(res));
    }

    @Test void test4()
    {
        var res = o.findOrder(2, new int[][]{ { 1, 0 }, { 0, 1 } });

        System.out.println(Arrays.toString(res));
    }
}
