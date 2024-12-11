package leetcode.DP;

public class _416 {
    private boolean r(int[] nums, int target, int i) {
        if (i == nums.length)
            return target == 0;

        if (target < 0)
            return false;

        return r(nums, target, i + 1) || r(nums, target - nums[i], i + 1);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];

        if ((sum & 1) > 0)
            return false;

        int target = sum / 2;

        return r(nums, target, 0);
    }
}
