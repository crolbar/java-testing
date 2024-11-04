package leetcode.Matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _994Test
{
    _994 o;
    @BeforeEach void setup() { o = new _994(); }

    @Test void test()
    {
        var res = o.orangesRotting(
          new int[][]{ { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } });

        System.out.println(res);
    }

    @Test void test1()
    {
        var res = o.orangesRotting(
          new int[][]{{ 2,1,1 },{ 0,1,1 },{ 1,0,1 }});

        System.out.println(res);
    }
}
