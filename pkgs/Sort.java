package pkgs;

import java.util.Arrays;

public class Sort {
    public enum SortType {
        Bubble,
        Quick
    }

    public static int[] quick(int[] nums) {
        class QuickSort {
            public static void qs(int[] nums, int li, int hi) {
                if (li >= hi) return;

                int pi = partiton(nums, li, hi);

                qs(nums, li, pi - 1);
                qs(nums, pi + 1, hi);
            }

            public static int partiton(int[] nums, int li, int hi) {
                int pivot = nums[hi];

                //System.out.printf("\n\nStarting partition with pivot: %d\n\n", pivot);
                //System.out.println(Arrays.toString(nums));

                int i = li - 1;

                for (int j = li; j < hi; j++) {
                    if (nums[j] < pivot) {
                        i++;
                        int tmp = nums[j];

                        //System.out.printf("Swaping: %d at %d with %d ad idx: %d\n", tmp, j, nums[i], i);

                        nums[j] = nums[i];
                        nums[i] = tmp;
                    }
                }

                i++;
                //System.out.printf("Swaping: %d ad %d with pivot: %d at %d\n", nums[i], i, pivot, hi);
                nums[hi] = nums[i];
                nums[i] = pivot;

                return i;
            }
        }

        QuickSort.qs(nums, 0, nums.length - 1);
        return nums;
    }

    public static int[] bubble(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }

        return nums;
    }

    public static void call(SortType st) {
        //int[] nums = {
        //    0, 25063, 5, 25062, 7, 25061, 9, 25060, 11, 25059, 13, 25058, 15, 25057, 17, 25056, 19,
        //    25055, 21, 25054, 23, 25053, 25, 25052, 27, 25051, 29, 25050, 31, 25049, 33, 25048, 35,
        //    25047, 37, 25046, 39, 25045, 41, 25044, 43, 25043, 45, 25042, 47, 25041, 49, 25040, 51,
        //    25039, 53, 25038, 55, 25037, 57, 25036, 59, 25035, 61, 25034, 63, 25033, 64, 65
        //};
        int[] nums = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};

        if (st == SortType.Bubble) {
            System.out.println(Arrays.toString(bubble(nums)));
        } else if (st == SortType.Quick) {
            System.out.println(Arrays.toString(quick(nums)));
        }
    }
}
