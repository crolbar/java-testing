package pkgs;

public
class Search
{
  public
    enum SearchType
    {
        Binary
    };

  public
    static int binary(int[] nums, int target)
    {
        int hi = nums.length - 1, li = 0;

        while (li <= hi) {
            int mi = li + (hi - li) / 2;

            if (nums[mi] == target) {
                return mi;
            } else if (target > nums[mi]) {
                li = mi + 1;
            } else if (target < nums[mi]) {
                hi = mi - 1;
            }
        }

        return -1;
    }

  public
    static void call(SearchType st)
    {
        int[] nums = { -1, 0, 2, 4, 6, 8 };
        int target = 8;

        int search_res = -1337;
        if (st == SearchType.Binary) {
            search_res = binary(nums, target);
        }

        System.out.println(search_res);
    }
}
