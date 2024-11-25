package leetcode.TwoPointers;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public
class _88Test
{
    _88 o = new _88();

    @Test void test()
    {
        int[] nums1 = new int[]{ 1, 2, 3, 0, 0, 0 };
        o.merge(nums1, 3, new int[]{ 2, 5, 6 }, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
