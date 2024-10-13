package leetcode.Heap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _973Test
{
    _973 o;

    @BeforeEach void setup() { o = new _973(); }

    @Test void test()
    {
        assertArrayEquals(o.kClosest(new int[][]{ { 1, 3 }, { -2, 2 } }, 1),
                          new int[][]{ { -2, 2 } });

        System.out.println();

        assertArrayEquals(
          o.kClosest(new int[][]{ { 3, 3 }, { 5, -1 }, { -2, 4 } }, 2),
          new int[][]{ { -2, 4 }, { 3, 3 } });
    }
}
