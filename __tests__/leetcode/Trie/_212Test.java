package leetcode.Trie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _212Test
{
    _212 o;
    @BeforeEach void setup() { o = new _212(); }

    @Test void test()
    {
        var res = o.findWords(new char[][]{ { 'o', 'a', 'a', 'n' },
                                            { 'e', 't', 'a', 'e' },
                                            { 'i', 'h', 'k', 'r' },
                                            { 'i', 'f', 'l', 'v' } },
                              new String[]{ "oath", "pea", "eat", "rain" });
        System.out.println(res);

        res = o.findWords(new char[][]{ { 'o', 'a', 'b', 'n' },
                                        { 'o', 't', 'a', 'e' },
                                        { 'a', 'h', 'k', 'r' },
                                        { 'a', 'f', 'l', 'v' } },
                          new String[]{ "oa", "oa", "oaa" });
        System.out.println(res);

        res = o.findWords(new char[][]{ { 'a', 'b', 'c', 'e' },
                                        { 'x', 'x', 'c', 'd' },
                                        { 'x', 'x', 'b', 'a' } },
                          new String[]{ "abc", "abcd" });

        System.out.println(res);
    }
}
