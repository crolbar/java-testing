package leetcode.DP;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public
class _152Test
{
    _152 o = new _152();

    @Test void test()
    {
        var res = o.maxProduct(new int[]{2,3,-2,4});
        System.out.println(res);
        assertEquals(6, res);
    }

    @Test void test2()
    {
        var res = o.maxProduct(new int[]{-2, 0, -1});
        System.out.println(res);
        assertEquals(0, res);
    }

    @Test void test3()
    {
        var res = o.maxProduct(new int[]{1,2,-3,4});
        System.out.println(res);
        assertEquals(4, res);
    }

    @Test void test4()
    {
        var res = o.maxProduct(new int[]{-2,3,-4});
        System.out.println(res);
        assertEquals(24, res);
    }
}
