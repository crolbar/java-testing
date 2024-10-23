package leetcode.BackTracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _40Test
{
    _40 o;
    @BeforeEach void setup() { o = new _40(); }

    @Test void test()
    {
        var res = o.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println(res);
    }
}
