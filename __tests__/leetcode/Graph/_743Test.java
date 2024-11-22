package leetcode.Graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public
class _743Test
{
    _743 o = new _743();

    @Test void test()
    {
        var res = o.networkDelayTime(
          new int[][]{ { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } }, 4, 2);

        System.out.println(res);
        assertEquals(res, 2);
    }

    @Test void test2()
    {
        var res = o.networkDelayTime(
          new int[][]{{ 1,2,1 },{ 2,3,1 },{ 1,4,4 },{ 3,4,1 }}, 4, 1);

        System.out.println(res);
        assertEquals(res, 3);
    }

    @Test void test3()
    {
        var res = o.networkDelayTime(
          new int[][]{{ 1,2,1 },{ 2,3,1 }}, 3, 2);

        System.out.println(res);
        assertEquals(res, -1);
    }

    @Test void test4()
    {
        var res = o.networkDelayTime(
          new int[][]{{ 1,2,1 },{ 2,1,3 }}, 2, 2);

        System.out.println(res);
        assertEquals(res, 3);
    }
}
