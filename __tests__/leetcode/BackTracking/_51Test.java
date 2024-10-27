package leetcode.BackTracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _51Test
{
    _51 o;
    @BeforeEach void setup() { o = new _51(); }

    @Test void test()
    {
        var res = o.solveNQueens(4);
        System.out.println(res);
    }
}
