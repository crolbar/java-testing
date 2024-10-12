package leetcode.Heap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class _1046Test {
    _1046 o;

    @BeforeEach void setup() { o = new _1046(); }

    @Test
    void test() {
        assertEquals(o.lastStoneWeight(new int[]{2,7,4,1,8,1}), 1);
    }
}
