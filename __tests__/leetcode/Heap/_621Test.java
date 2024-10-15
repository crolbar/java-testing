
package leetcode.Heap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _621Test
{
    _621 o;
    @BeforeEach void setup() { o = new _621(); }

    @Test void test()
    {
        // assertEquals(o.leastInterval(new char[]{ 'A','A','A','B','B','B' },
        // 2), 8);
        int res =
          o.leastInterval(new char[]{ 'A', 'B', 'C', 'D', 'E', 'F' }, 2);
        System.out.println(res);
        assertEquals(res, 6);

        res =
          o.leastInterval(new char[]{ 'A', 'B', 'C', 'A', 'E', 'D', 'A' }, 2);
        System.out.println(res);
        assertEquals(res, 7);
    }
}
