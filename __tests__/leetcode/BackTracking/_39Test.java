package leetcode.BackTracking;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _39Test
{
    _39 o;
    @BeforeEach void setup() { o = new _39(); }

    @Test void test() {
        List<List<Integer>> res = o.combinationSum(new int[]{2,3,6,7}, 7);

        System.out.println(res);
    }
}
