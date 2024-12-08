package leetcode.DP;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

public
class _139Test
{
    _139 o = new _139();

    @Test void test()
    {
        var res = o.wordBreak("leetcode", Arrays.asList("leet", "code"));
        System.out.println(res);
        assertEquals(true, res);
    }

    @Test void test2()
    {
        var res = o.wordBreak("applepenapple", Arrays.asList("apple","pen","ape"));
        System.out.println(res);
        assertEquals(true, res);
    }

    @Test void test3()
    {
        var res = o.wordBreak("catsincars", Arrays.asList("cats","cat","sin","in","car"));
        System.out.println(res);
        assertEquals(false, res);
    }
}
