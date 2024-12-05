package leetcode.DP;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public
class _91Test
{
    _91 o = new _91();

    @Test void test()
    {
        var res = o.numDecodings("12");
        System.out.println(res);
        assertEquals(2, res);
    }

    @Test void test2()
    {
        var res = o.numDecodings("226");
        System.out.println(res);
        assertEquals(3, res);
    }
}
