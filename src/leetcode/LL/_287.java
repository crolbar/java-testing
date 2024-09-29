package leetcode.LL;

public
class _287
{
  public
    int findDuplicate(int[] nums)
    {
        int slow = 0;
        int fast = 0;

        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);

        int slow2 = 0;
        for (;;) {
            slow = nums[slow];
            slow2 = nums[slow2];

            if (slow2 == slow)
                return slow;
        }
    }
}
