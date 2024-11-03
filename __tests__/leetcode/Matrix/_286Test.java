package leetcode.Matrix;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _286Test
{
    _286 o;
    @BeforeEach void setup() { o = new _286(); }

    @Test void test()
    {
        var mtrix = new int[][]{ { 2147483647, -1, 0, 2147483647 },
                                 { 2147483647, 2147483647, 2147483647, -1 },
                                 { 2147483647, -1, 2147483647, -1 },
                                 { 0, -1, 2147483647, 2147483647 } };

        for (int i = 0; i < mtrix.length; i++) {
            System.out.println(Arrays.toString(mtrix[i]));
        }

        o.islandsAndTreasure(mtrix);

        System.out.println();

        for (int i = 0; i < mtrix.length; i++) {
            System.out.println(Arrays.toString(mtrix[i]));
        }
    }

    @Test void test2()
    {
        var mtrix = new int[][]{ { 2147483647, 2147483647, 2147483647 },
                                 { 2147483647, -1, 2147483647 },
                                 { 0, 2147483647, 2147483647 } };

        for (int i = 0; i < mtrix.length; i++) {
            System.out.println(Arrays.toString(mtrix[i]));
        }

        o.islandsAndTreasure(mtrix);

        System.out.println();

        for (int i = 0; i < mtrix.length; i++) {
            System.out.println(Arrays.toString(mtrix[i]));
        }
    }
}
