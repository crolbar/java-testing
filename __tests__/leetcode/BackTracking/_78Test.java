package leetcode.BackTracking;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _78Test
{
    _78 o;
    @BeforeEach void setup() { o = new _78(); }

    @Test void test() {
        List<List<Integer>> res = o.subsets(new int[]{1,2,3});

    }
}
