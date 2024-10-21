package leetcode.BackTracking;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _46Test
{
    _46 o;
    @BeforeEach void setup() { o = new _46(); }

    @Test void test() {
        List<List<Integer>> res = o.permute(new int[]{1,2,3});

        System.out.println(res);
    }
}
