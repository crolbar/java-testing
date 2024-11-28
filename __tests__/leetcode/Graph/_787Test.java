package leetcode.Graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public
class _787Test
{
    _787 o = new _787();

    @Test void test()
    {
        var res = o.findCheapestPrice(4,
                                      new int[][]{ { 0, 1, 100 },
                                                   { 1, 2, 100 },
                                                   { 2, 0, 100 },
                                                   { 1, 3, 600 },
                                                   { 2, 3, 200 } },
                                      0,
                                      3,
                                      1);

        System.out.println(res);
        assertEquals(res, 700);
    }

    @Test void test2()
    {
        var res = o.findCheapestPrice(
          3,
          new int[][]{ { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } },
          0,
          2,
          1);

        System.out.println(res);
        assertEquals(res, 200);
    }

    @Test void test3()
    {
        var res = o.findCheapestPrice(
          4,
          new int[][]{
            { 0, 1, 200 }, { 1, 2, 100 }, { 1, 3, 300 }, { 2, 3, 100 } },
          0,
          3,
          1);

        System.out.println(res);
        assertEquals(res, 500);
    }
}
