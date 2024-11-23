package leetcode.Graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public
class _778Test
{
    _778 o = new _778();

    @Test void test()
    {
        var res = o.swimInWater(new int[][]{ { 0, 2 }, { 1, 3 } });
        System.out.println(res);
        // assertEquals(3, res);
    }

    @Test void test2()
    {
        var res = o.swimInWater(new int[][]{ { 0, 1, 2, 3, 4 },
                                             { 24, 23, 22, 21, 5 },
                                             { 12, 13, 14, 15, 16 },
                                             { 11, 17, 18, 19, 20 },
                                             { 10, 9, 8, 7, 6 } });
        System.out.println(res);
        // assertEquals(16, res);
    }
}
