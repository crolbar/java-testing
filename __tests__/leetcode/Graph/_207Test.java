package leetcode.Graph;

import org.junit.jupiter.api.Test;

public
class _207Test
{
    _207 o = new _207();

    @Test void test()
    {
        var res = o.canFinish(2, new int[][]{ { 1, 0 } });

        System.out.println(res);
    }

    @Test void test3()
    {
        var res = o.canFinish(2, new int[][]{ { 1, 0 }, { 0, 1 } });

        System.out.println(res);
    }

    @Test void test1()
    {
        var res =
          o.canFinish(5, new int[][]{ { 1, 4 }, { 2, 4 }, { 3, 1 }, { 3, 2 } });

        System.out.println(res);
    }

    @Test void test4()
    {
        var res = o.canFinish(20,
                              new int[][]{ { 0, 10 },
                                           { 3, 18 },
                                           { 5, 5 },
                                           { 6, 11 },
                                           { 11, 14 },
                                           { 13, 1 },
                                           { 15, 1 },
                                           { 17, 4 } });

        System.out.println(res);
    }
}
