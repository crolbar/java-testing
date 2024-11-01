package sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public
class quickTest
{
    @Test void test()
    {
        int[] data = new int[]{ 2, 6, 1, 3 };

        quick.sort(data);

        System.err.println(Arrays.toString(data));
        assertArrayEquals(data, new int[]{ 1, 2, 3, 6 });
    }
}
