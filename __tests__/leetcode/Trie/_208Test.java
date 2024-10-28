package leetcode.Trie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _208Test
{
    _208 o;
    @BeforeEach void setup() { o = new _208(); }

    @Test void test()
    {
        Trie trie = o.t;

        trie.insert("hello");


        assertEquals(trie.search("hello"), true);
        assertEquals(trie.search("hell"), false);

        assertEquals(trie.startsWith("hell"), true);
        assertEquals(trie.startsWith("hello"), true);
        assertEquals(trie.startsWith("helllo"), false);
        assertEquals(trie.startsWith("hallo"), false);
    }
}
