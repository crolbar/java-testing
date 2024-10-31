package leetcode.Math;

public
class _66
{
  public
    int[] plusOne(int[] digits)
    {
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1]++;
            return digits;
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            }

            if (i == 0) {
                int[] res = new int[digits.length + 1];

                for (int j = 0; j < digits.length; j++) {
                    res[j] = digits[j];
                }

                res[1] = 0;
                res[0] = 1;
                return res;
            }

            digits[i] = 0;
        }

        return digits;
    }
}
