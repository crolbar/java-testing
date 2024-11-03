package leetcode.Math;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _67Test
{
    _67 o;
    @BeforeEach void setup() { o = new _67(); }

    @Test void test()
    {
        String res = o.addBinary("11", "1");

        System.out.println(res);
        assertEquals(res, "100");
    }

    @Test void test2()
    {
        String res = o.addBinary("1010", "1011");

        System.out.println(res);
        assertEquals(res, "10101");
    }

    @Test void test3()
    {
        String res = o.addBinary("100", "110010");

        System.out.println(res);
        assertEquals(res, "110110");
    }
}
