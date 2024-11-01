package leetcode.Matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _695Test
{
    _695 o;
    @BeforeEach void setup() { o = new _695(); }

    @Test void test()
    {
        var r = o.maxAreaOfIsland(new int[][]{
          { 1, 1, 1, 1, 0 },
          { 1, 1, 0, 1, 0 },
          { 1, 1, 0, 0, 0 },
          { 0, 0, 0, 0, 0 },
        });

        System.out.println(r);

        r = o.maxAreaOfIsland(new int[][]{ { 1, 1, 0, 0, 0 },
                                           { 1, 1, 0, 0, 0 },
                                           { 0, 0, 1, 0, 0 },
                                           { 0, 0, 0, 1, 1 } });

        System.out.println(r);
    }
}
