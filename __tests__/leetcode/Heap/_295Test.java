package leetcode.Heap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _295Test
{
    _295 o;

    @BeforeEach void setup() { o = new _295(); }

    @Test void test()
    {
        o.m.addNum(1);
        o.m.addNum(2);

        System.out.println(o.m.maxHeap);
        System.out.println(o.m.minHeap);
        System.out.println(o.m.findMedian());
        assertEquals(1.5, o.m.findMedian());

        o.m.addNum(3);

        assertEquals(2.0, o.m.findMedian());
    }

    @Test void test2()
    {
        o.m.addNum(0);
        o.m.addNum(0);

        // System.out.println(Arrays.toString(o.m.data));
        // System.out.println(o.m.findMedian());
        assertEquals(0.0, o.m.findMedian());
    }
}
