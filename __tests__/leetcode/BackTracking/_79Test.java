package leetcode.BackTracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _79Test
{
    _79 o;
    @BeforeEach void setup() { o = new _79(); }

    @Test void test()
    {
        var res = o.exist(
          new char[][]{
            { 'A', 'B', 'C', 'E' },
            { 'S', 'F', 'C', 'S' },
            { 'A', 'D', 'E', 'E' },
          },
          "ABCCED");

        System.out.println(res);
    }
}
