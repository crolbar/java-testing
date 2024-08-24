package pkgs;

import java.util.Arrays;

public class Sort {
    public enum SortType {
        Bubble
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
        int[] nums = {
            0, 25063, 5, 25062, 7, 25061, 9, 25060, 11, 25059, 13, 25058, 15, 25057, 17, 25056, 19,
            25055, 21, 25054, 23, 25053, 25, 25052, 27, 25051, 29, 25050, 31, 25049, 33, 25048, 35,
            25047, 37, 25046, 39, 25045, 41, 25044, 43, 25043, 45, 25042, 47, 25041, 49, 25040, 51,
            25039, 53, 25038, 55, 25037, 57, 25036, 59, 25035, 61, 25034, 63, 25033, 64, 65
        };

        if (st == SortType.Bubble) {
            System.out.println(Arrays.toString(bubble(nums)));
        }
    }
}
