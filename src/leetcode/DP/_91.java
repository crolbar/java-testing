package leetcode.DP;

import java.util.Arrays;

public
class _91
{
  public
    int numDecodings(String s)
    {
        int[] arr = new int[s.length() + 1];
        arr[s.length()] = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                arr[i] = 0;
            } else {
                arr[i] = arr[i + 1];

                if (i + 1 >= s.length())
                    continue;

                if (s.charAt(i) == '1' ||
                    (s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                    arr[i] += arr[i + 2];
                }
            }
        }

        return arr[0];
    }
}
