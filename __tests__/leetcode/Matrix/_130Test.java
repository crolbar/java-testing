package leetcode.Matrix;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public
class _130Test
{
    _130 o = new _130();

    @Test void test()
    {
        var m = new char[][]{ { 'X', 'X', 'X', 'X' },
                              { 'X', 'O', 'O', 'X' },
                              { 'X', 'X', 'O', 'X' },
                              { 'X', 'O', 'X', 'X' } };

        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }

        System.out.println();
        o.solve(m);

        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }

    @Test void test2()
    {
        var m = new char[][]{ { 'X', 'O', 'X', 'O', 'X', 'O' },
                              { 'O', 'X', 'O', 'X', 'O', 'X' },
                              { 'X', 'O', 'X', 'O', 'X', 'O' },
                              { 'O', 'X', 'O', 'X', 'O', 'X' } };

        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }

        System.out.println();
        o.solve(m);

        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }

    @Test void test3()
    {
        var m = new char[][]{
            { 'O', 'O', 'O', 'O', 'O', 'O' }, { 'O', 'X', 'X', 'X', 'X', 'O' },
            { 'O', 'X', 'O', 'O', 'X', 'O' }, { 'O', 'X', 'O', 'O', 'X', 'O' },
            { 'O', 'X', 'X', 'X', 'X', 'O' }, { 'O', 'O', 'O', 'O', 'O', 'O' }
        };

        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }

        System.out.println();
        o.solve(m);

        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }
}
