package leetcode.String;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public
class _127Test
{
    _127 o = new _127();

    @Test void test()
    {
        var res = o.ladderLength("hit",
                                 "cog",
                                 new ArrayList<>(Arrays.asList(
                                   "hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(res);
        assertEquals(5, res);
    }

    @Test void test2()
    {
        var res = o.ladderLength(
          "hit",
          "cog",
          new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log")));
        System.out.println(res);
        assertEquals(0, res);
    }

    @Test void test3()
    {
        var res = o.ladderLength(
          "cat",
          "sag",
          new ArrayList<>(Arrays.asList("bat", "bag", "sag", "dag", "dot")));
        System.out.println(res);
        assertEquals(4, res);
    }

    @Test void test4()
    {
        var res = o.ladderLength(
          "hot", "dog", new ArrayList<>(Arrays.asList("hot", "dog")));
        System.out.println(res);
        assertEquals(0, res);
    }

    @Test void test5()
    {
        var res = o.ladderLength(
          "a", "z", new ArrayList<>(Arrays.asList("b")));
        System.out.println(res);
        assertEquals(0, res);
    }
}
