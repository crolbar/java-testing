package leetcode.DP;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public
class _198Test
{
    _198 o = new _198();

    @Test void test()
    {
        var res = o.rob(new int[]{1,2,3,1});
        System.out.println(res);
        assertEquals(4, res);
    }

    @Test void test2()
    {
        var res = o.rob(new int[]{2,9,8,3,6});
        System.out.println(res);
        assertEquals(16, res);
    }
}
