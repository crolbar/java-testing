package leetcode.DP;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public
class _1143Test
{
    _1143 o = new _1143();

    @Test void test()
    {
        var res = o.longestCommonSubsequence("abcde", "ace");
        System.out.println(res);
        assertEquals(3, res);
    }

    @Test void test2()
    {
        var res = o.longestCommonSubsequence("abc", "abc");
        System.out.println(res);
        assertEquals(3, res);
    }

    @Test void test3()
    {
        var res = o.longestCommonSubsequence("abcd", "efgh");
        System.out.println(res);
        assertEquals(0, res);
    }

    @Test void test4()
    {
        var res = o.longestCommonSubsequence("ezupkr", "ubmrapg");
        System.out.println(res);
        assertEquals(2, res);
    }
}
