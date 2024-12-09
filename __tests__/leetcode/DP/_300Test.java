package leetcode.DP;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

public
class _300Test
{
    _300 o = new _300();

    @Test void test()
    {
        var res = o.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        System.out.println(res);
        assertEquals(4, res);
    }

    @Test void test2()
    {
        var res = o.lengthOfLIS(new int[]{0,1,0,3,2,3});
        System.out.println(res);
        assertEquals(4, res);
    }

    @Test void test3()
    {
        var res = o.lengthOfLIS(new int[]{7,7,7,7,7,7,7});
        System.out.println(res);
        assertEquals(1, res);
    }

    @Test void test4()
    {
        var res = o.lengthOfLIS(new int[]{ 3,5,6,2,5,4,19,5,6,7,12 });
        System.out.println(res);
        assertEquals(6, res);
    }
}
