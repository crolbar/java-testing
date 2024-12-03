package leetcode.DP;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public
class _5Test
{
    _5 o = new _5();

    @Test void test()
    {
        var res = o.longestPalindrome("babad");
        System.out.println(res);
        assertEquals("bab", res);
    }

    @Test void test2()
    {
        var res = o.longestPalindrome("cbbd");
        System.out.println(res);
        assertEquals("bb", res);
    }

    @Test void test3()
    {
        var res = o.longestPalindrome("ababd");
        System.out.println(res);
        assertEquals("aba", res);
    }
}
