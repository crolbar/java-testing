package leetcode.String;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public
class _6Test
{
    _6 o = new _6();

    @Test void test()
    {
        String out = o.convert("PAYPALISHIRING", 3);
        System.out.println(out);
        assertEquals("PAHNAPLSIIGYIR", out);
    }

    @Test void test2()
    {
        String out = o.convert("PAYPALISHIRING", 4);
        System.out.println(out);
        assertEquals("PINALSIGYAHRPI", out);
    }

    @Test void test3()
    {
        String out = o.convert("AB", 1);
        System.out.println(out);
        assertEquals("AB", out);
        System.out.println("after");
    }
}
