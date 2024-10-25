package leetcode.BackTracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _131Test
{
    _131 o;
    @BeforeEach void setup() { o = new _131(); }

    @Test void test()
    {
        var res = o.partition("aab");
        System.out.println(res);
    }
}
