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
        //o.subsets(new int[]{1,2,3});
        o.subsets(new int[]{3,2,4,1});
    }
}
