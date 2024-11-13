package leetcode.Math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public
class _70Test
{
    _70 o = new _70();

    @Test void test()
    {
        var res = o.climbStairs(2);
        System.out.println(res);
        assertEquals(res, 2);
    }

    @Test void test2()
    {
        var res = o.climbStairs(3);
        System.out.println(res);
        assertEquals(res, 3);
    }

    @Test void test3()
    {
        var res = o.climbStairs(4);
        System.out.println(res);
        assertEquals(res, 5);
    }

    @Test void test4()
    {
        var res = o.climbStairs(44);
        System.out.println(res);
    }
}
