package pkgs;

import java.util.Arrays;
import java.util.HashSet;

public class leet {
    public static void main() {
        System.out.println("hi");
    }
}

class pES {
    public static int[] productExceptSelf(int[] nums) {
        int[] out = new int[nums.length];

        // store the prod of all element to the left of i in out[i]
        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            out[i] += prod;
            prod *= nums[i];
        }

        // reset var so we can start to track the prod from the right
        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // then use the prod to the left and multiply it with the prod
            // to the right (that's why we start from the end)
            out[i] = out[i] * prod;
            prod *= nums[i];
        }

        // basicly we get
        //
        // left prod
        // [1, 1, 2, 8]
        //
        // right prod
        // [48, 24, 6, 1]
        //
        // and we just multiply them
        //
        // [48, 24, 12, 8]

        return out;
    }

    public static void main() {
        int[] nums = {1, 2, 4, 6};

        System.out.println(Arrays.toString(nums));
        int[] out = productExceptSelf(nums);

        System.out.println(Arrays.toString(out));
    }
}

class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            if (!set.contains(n - 1)) {
                int count = 0;

                while (set.contains(n)) {
                    n++;
                    count++;
                }

                num = Math.max(num, count);
            }
        }

        return num;
    }

    public static void main() {
        // int[] nums = {0, 0, 2};
        int[] nums = {2, 20, 4, 10, 3, 4, 5};
        // int[] nums = {0, 3, 2, 5, 4, 6, 1, 1};
        // int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};

        System.out.println(Arrays.toString(nums));
        int out = longestConsecutive(nums);
        System.out.println(out);
    }
}
