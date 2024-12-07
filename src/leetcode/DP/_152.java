package leetcode.DP;

public
class _152
{
  public
    int maxProduct(int[] nums)
    {
        if (nums.length == 1)
            return nums[0];

        int max = 0;
        int currMin = 1;
        int currMax = 1;

        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i] * currMax;
            currMax =
              Math.max(Math.max(nums[i] * currMax, nums[i] * currMin), nums[i]);

            currMin = Math.min(Math.min(nums[i] * currMin, tmp), nums[i]);

            max = Math.max(max, currMax);
        }

        return max;
    }
}
