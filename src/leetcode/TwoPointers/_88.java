package leetcode.TwoPointers;

import java.util.Arrays;

public
class _88
{
  public
    void merge(int[] nums1, int m, int[] nums2, int n)
    {
        int p1 = 0, p2 = 0, i = 0;
        int[] dub = Arrays.copyOf(nums1, m);

        while (p1 < m || p2 < n) {
            if (p2 >= n) {
                nums1[i++] = dub[p1++];
                continue;
            }

            if (p1 >= m) {
                nums1[i++] = nums2[p2++];
                continue;
            }

            if (dub[p1] < nums2[p2]) {
                nums1[i++] = dub[p1++];
                continue;
            }

            if (dub[p1] >= nums2[p2]) {
                nums1[i++] = nums2[p2++];
            }
        }
    }
}
