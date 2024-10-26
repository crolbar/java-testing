package leetcode.BackTracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _17Test
{
    _17 o;
    @BeforeEach void setup() { o = new _17(); }

    @Test void test()
    {
        var res = o.letterCombinations("23");
        System.out.println(res);
    }
}
