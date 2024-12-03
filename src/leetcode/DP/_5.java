package leetcode.DP;

public
class _5
{
    private int[] manacher(String s) {
        StringBuilder sb = new StringBuilder("|");

        for (char c : s.toCharArray())
            sb.append(c).append("|");

        int[] p = new int[sb.length()];

        int l = 0, r = 0;
        for (int i = 0; i < sb.length(); i++) {
            p[i] = (i < r)
                ? Math.min(r - i, p[l + (r - i)])
                : 0;
            System.out.printf("at: %d, p[i]: %d\n", i, p[i]);

            while (
                   i - p[i] >= 0 // start out of bound check
                   && i + p[i] < sb.length() // end out of bound check
                   && sb.charAt(i - p[i]) == sb.charAt(i + p[i])
                   )
                p[i]++;

            p[i]--;

            if (i + p[i] > r) {
                l = i - p[i];
                r = i + p[i];
            }
        }

        return p;
    }

    public String longestPalindrome(String s) {
        int[] manacher = manacher(s);
        int len = 0;
        int ci = 0;

        for (int i = 0; i < manacher.length; i++) {
            if (manacher[i] > len) {
                len = manacher[i];
                ci = i;
            }
        }

        int si = (ci - len) / 2;
        return s.substring(si, si + len);
    }
}
