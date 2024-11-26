
package leetcode.String;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public
class _953Test
{
    _953 o = new _953();

    @Test void test()
    {
        var res = o.isAlienSorted(new String[]{ "hello", "leetcode" },
                                  "hlabcdefgijkmnopqrstuvwxyz");
        System.out.println(res);
        assertEquals(true, res);
    }

    @Test void test2()
    {
        var res = o.isAlienSorted(new String[]{ "word", "world", "row" },
                                  "worldabcefghijkmnpqstuvxyz");
        System.out.println(res);
        assertEquals(false, res);
    }
}
