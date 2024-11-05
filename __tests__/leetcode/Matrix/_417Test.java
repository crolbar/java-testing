package leetcode.Matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _417Test
{
    _417 o;
    @BeforeEach void setup() { o = new _417(); }

    @Test void test()
    {
        var res = o.pacificAtlantic(new int[][]{ { 1, 2, 2, 3, 5 },
                                                 { 3, 2, 3, 4, 4 },
                                                 { 2, 4, 5, 3, 1 },
                                                 { 6, 7, 1, 4, 5 },
                                                 { 5, 1, 1, 2, 4 } });
        System.out.println(res);
    }

    @Test void test2()
    {
        var res = o.pacificAtlantic(new int[][]{ { 1 } });
        System.out.println(res);
    }

    @Test void test3()
    {
        var res = o.pacificAtlantic(
          new int[][]{ 
              { 1, 2, 3 },
              { 8, 9, 4 },
              { 7, 6, 5 } });

        System.out.println("have: " + res);
        System.out.println("need: " + "[[0, 2], [1, 0], [1, 1], [1, 2], [2, 0], [2, 1], [2, 2]]");
    }
}
