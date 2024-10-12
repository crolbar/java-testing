package leetcode.Heap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _703Test
{
    _703 o;

    @BeforeEach void setup() { o = new _703(); }

    @Test
    void test() {
        KthLargest k = o.KthLargest(3, new int[]{4, 5, 8, 2});
        int actual = k.add(3);
        System.out.println(actual);
        assertEquals(actual, 4);

        actual = k.add(5);
        System.out.println(actual);
        assertEquals(actual, 5);

        actual = k.add(10);
        System.out.println(actual);
        assertEquals(actual, 5);

        assertEquals(k.add(9), 8);
        assertEquals(k.add(4), 8);
    }
}
