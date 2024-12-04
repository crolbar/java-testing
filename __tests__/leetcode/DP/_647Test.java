package leetcode.DP;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public
class _647Test
{
    _647 o = new _647();

    @Test void test()
    {
        var res = o.countSubstrings("abc");
        System.out.println(res);
        assertEquals(3, res);
    }

    @Test void test2()
    {
        var res = o.countSubstrings("aaa");
        System.out.println(res);
        assertEquals(6, res);
    }
}
