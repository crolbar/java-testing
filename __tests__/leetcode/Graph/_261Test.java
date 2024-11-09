package leetcode.Graph;

import org.junit.jupiter.api.Test;

public
class _261Test
{
    _261 o = new _261();

    @Test void test()
    {
        var res =
          o.validTree(5, new int[][]{ { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } });

        System.out.println(res);
    }

    @Test void test2()
    {
        var res = o.validTree(
          5, new int[][]{ { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } });

        System.out.println(res);
    }

    @Test void test3()
    {
        var res =
          o.validTree(5, new int[][]{ { 0, 1 }, { 1, 3 }, { 3, 2 }, { 1, 4 } });

        System.out.println(res);
    }
}
