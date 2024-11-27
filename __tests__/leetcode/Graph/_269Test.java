package leetcode.Graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public
class _269Test
{
    _269 o = new _269();

    @Test void test()
    {
        var res = o.foreignDictionary(new String[]{ "z", "o" });

        System.out.println(res);

        assertEquals("zo", res);
    }

    @Test void test2()
    {
        var res = o.foreignDictionary(
          new String[]{ "hrn", "hrf", "er", "enn", "rfnn" });

        System.out.println(res);

        assertEquals("hernf", res);
    }

    @Test void test3()
    {
        var res = o.foreignDictionary(new String[]{ "zyx", "yxw", "wvu" });

        System.out.println(res);

        assertEquals("zyxwvu", res);
    }

    @Test void test4()
    {
        var res = o.foreignDictionary(new String[]{ "wrtkj", "wrt" });

        System.out.println(res);

        assertEquals("", res);
    }
}
