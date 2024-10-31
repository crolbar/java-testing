package leetcode.Math;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public
class _66Test
{
    _66 o;
    @BeforeEach void setup() { o = new _66(); }

    @Test void test()
    {

        var res = o.plusOne(new int[]{ 1, 2, 3 });

        System.out.println(Arrays.toString(res));


        System.out.println();

        res = o.plusOne(new int[]{ 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 });

        System.out.println(Arrays.toString(res));


        System.out.println();

        res = o.plusOne(new int[]{9});

        System.out.println(Arrays.toString(res));


        System.out.println();

        res = o.plusOne(new int[]{9,9, 9, 9, 9});

        System.out.println(Arrays.toString(res));
    }
}
