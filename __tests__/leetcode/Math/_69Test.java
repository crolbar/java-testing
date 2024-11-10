package leetcode.Math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public
class _69Test
{
    _69 o = new _69();

    @Test void test()
    {
        var res = o.mySqrt(4);
        System.out.println(res);
        assertEquals(res, 2);
    }

    @Test void test2()
    {
        var res = o.mySqrt(8);
        System.out.println(res);
        assertEquals(res, 2);
    }

    @Test void test3()
    {
        var res = o.mySqrt(16);
        System.out.println(res);
        assertEquals(res, 4);
    }
}
