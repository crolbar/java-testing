package leetcode.DP;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public
class _416Test
{
    _416 o = new _416();

    @Test void test()
    {
        var res = o.canPartition(new int[]{1,5,11,5});
        System.out.println(res);
        assertEquals(true, res);
    }

    @Test void test2()
    {
        var res = o.canPartition(new int[]{1,2,3,5});
        System.out.println(res);
        assertEquals(false, res);
    }
}
