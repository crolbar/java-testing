package leetcode.BackTracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _90Test
{
    _90 o;
    @BeforeEach void setup() { o = new _90(); }

    @Test void test() {
       var res = o.subsetsWithDup(new int[]{1,2,2});

       System.out.println(res);
    }
}
