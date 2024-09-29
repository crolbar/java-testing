package leetcode.LL;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public
class _146Test
{
    @Test void test()
    {
        LRUCache lru = new LRUCache(2);

        lru.put(1, 1);
        lru.put(2, 2);
        assertEquals(lru.get(1), 1);
        lru.put(3, 3);
        assertEquals(lru.get(2), -1);
        lru.put(4, 4);
        assertEquals(lru.get(1), -1);
        assertEquals(lru.get(3), 3);
        assertEquals(lru.get(4), 4);
    }

    @Test void test2()
    {
        LRUCache lru = new LRUCache(2);

        assertEquals(lru.get(2), -1);
        lru.put(2, 6);
        assertEquals(lru.get(1), -1);
        lru.put(1, 5);
        lru.put(1, 2);
        assertEquals(lru.get(1), 2);
        assertEquals(lru.get(2), 6);
    }
}
