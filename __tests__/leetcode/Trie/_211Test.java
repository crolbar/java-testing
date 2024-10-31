package leetcode.Trie;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _211Test
{
    _211 o;
    @BeforeEach void setup() { o = new _211(); }

    @Test void test()
    {
        WordDictionary trie = o.t;

        //trie.addWord("hello");
        //
        //assertEquals(trie.search("hel"), false);
        //assertEquals(trie.search("hello"), true);

        trie.addWord("bye");

        assertEquals(trie.search("bye"), true);
        assertEquals(trie.search(".ye"), true);
        assertEquals(trie.search("b.e"), true);
        assertEquals(trie.search("by."), true);
        assertEquals(trie.search("b.."), true);
    }
}
