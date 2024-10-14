package leetcode.Heap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _215Test
{
    _215 o;
    @BeforeEach void setup() { o = new _215(); }

    @Test void test()
    {
        assertEquals(o.findKthLargest(new int[]{ 3, 2, 1, 5, 6, 4 }, 2), 5);

        assertEquals(
          o.findKthLargest(new int[]{ 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4), 4);
    }
}
