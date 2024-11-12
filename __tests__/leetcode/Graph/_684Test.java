package leetcode.Graph;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public
class _684Test
{
    _684 o = new _684();

    @Test void test()
    {
        var res = o.findRedundantConnection(
          new int[][]{ { 1, 2 }, { 1, 3 }, { 2, 3 } });

        System.out.println(Arrays.toString(res));
        assertArrayEquals(res, new int[]{ 2, 3 });
    }

    @Test void test2()
    {
        var res = o.findRedundantConnection(
          new int[][]{ { 1, 2 }, { 1, 3 }, { 1, 4 }, { 3, 4 }, { 4, 5 } });

        System.out.println(Arrays.toString(res));
        assertArrayEquals(res, new int[]{ 3, 4 });
    }

    @Test void test3()
    {
        var res = o.findRedundantConnection(
          new int[][]{ { 1, 2 }, { 1, 3 }, { 3, 4 }, { 2, 4 } });

        System.out.println(Arrays.toString(res));
        assertArrayEquals(res, new int[]{ 2, 4 });
    }

    @Test void test4()
    {
        var res = o.findRedundantConnection(
          new int[][]{ { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } });

        System.out.println(Arrays.toString(res));
        assertArrayEquals(res, new int[]{ 1, 4 });
    }

    @Test void test5()
    {
        var res = o.findRedundantConnection(new int[][]{ { 2, 7 },
                                                         { 7, 8 },
                                                         { 3, 6 },
                                                         { 2, 5 },
                                                         { 6, 8 },
                                                         { 4, 8 },
                                                         { 2, 8 },
                                                         { 1, 8 },
                                                         { 7, 10 },
                                                         { 3, 9 } });

        System.out.println(Arrays.toString(res));
        assertArrayEquals(res, new int[]{ 2, 8 });
    }
}
