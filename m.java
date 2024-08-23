public class m {
    public static int search(int[] nums, int target) {
        int hi = nums.length - 1, li = 0;

        while (li <= hi) {
            int mi = li + (hi - li) / 2;

            if (nums[mi] == target) {
                return mi;
            } else if (nums[mi] < target) {
                li = mi + 1;
            } else if (nums[mi] > target) {
                hi = mi - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 2, 4, 6, 8};
        int target = 8;

        System.out.println(search(nums, target));
    }
}
