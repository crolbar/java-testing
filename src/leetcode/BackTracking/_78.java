package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class _78 {
    ArrayList<Integer> get(int[] nums, int bits) {
        ArrayList<Integer> l = new ArrayList<>();

        int i = 0;

        int b = 1;
        while (b <= bits) {
            if ((bits & b) > 0) {
                l.add(nums[i]);
            }

            b *= 2;
            i++;
        }

        return l;
    }

    void r(int[] nums, ArrayList<List<Integer>> res, int bits, int i) {
        if (i > nums.length) {
            System.out.printf("[Return]:\n\n");
            return;
        }

        System.out.printf("[ADDING]: %s, %s\n\n", Integer.toBinaryString(bits), get(nums, bits));
        res.add(get(nums, bits));

        int b = (bits == 0) ? 1 : Integer.highestOneBit(bits);

        while (i < nums.length) {

            if (bits != 0) {
                b *= 2;
            }

            System.out.printf("i: %d, bits: %s, bits(%d) | b(%d): %s\n", i, Integer.toBinaryString(bits), bits, b, Integer.toBinaryString(bits | b));

            r(nums, res, bits | b, ++i);

            if (bits == 0) {
                b *= 2;
            }
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();

        r(nums, res, 0, 0);

        System.out.println(res);
        System.out.println("[[], [3], [2], [2, 3], [4], [3, 4], [2, 4], [2, 3, 4], [1], [1, 3], [1, 2], [1, 2, 3], [1, 4], [1, 3, 4], [1, 2, 4], [1, 2, 3, 4]]");
                          //[[], [3], [3, 2], [3, 2, 4], [3, 2, 4, 1], [3, 2, 4, 1], [3, 4], [3, 2, 4, 1], [3, 1], [2], [2, 4], [2, 4, 1], [2, 1], [4], [4, 1], [1]]
        return res;
    }
}
