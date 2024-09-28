package leetcode.LL;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _287Test
{
    _287 o;
    @BeforeEach void setup() { o = new _287(); }

    @Test void test()
    {
        assertEquals(o.findDuplicate(new int[]{ 1, 3, 4, 2, 2 }), 2);
    }
    @Test void test2()
    {
        assertEquals(o.findDuplicate(new int[]{ 3, 1, 3, 4, 2 }), 3);
    }
    @Test void test3()
    {
        assertEquals(o.findDuplicate(new int[]{ 3, 3, 3, 3, 3 }), 3);
    }
    @Test void test4()
    {
        assertEquals(o.findDuplicate(new int[]{ 2, 5, 9, 6, 9, 3, 8, 9, 7, 1 }),
                     9);
    }
}
