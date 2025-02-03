package leetcode.DP;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public
class _62Test
{
    _62 o = new _62();

    @Test void test()
    {
        var res = o.uniquePaths(3, 7);
        System.out.println(res);
        assertEquals(28, res);
    }

    @Test void test2()
    {
        var res = o.uniquePaths(3, 2);
        System.out.println(res);
        assertEquals(3, res);
    }
}
