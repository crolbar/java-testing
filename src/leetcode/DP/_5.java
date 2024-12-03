package leetcode.DP;

public
class _5
{
    private int[] getLP(String s, int l, int r)
    {
        while (s.charAt(l) == s.charAt(r)) {
            l--;
            r++;

            if (l < 0)
                break;

            if (r >= s.length())
                break;
        }

        return new int[]{l + 1, r};
    }

    public String longestPalindrome(String s) {
        int[] res = new int[]{0, 1};

        for (int i = 0; i < s.length(); i++) {
            int[] ss = getLP(s, i, i);
            if (ss[1] - ss[0] > res[1] - res[0])
                res = ss;

            if (i == s.length() - 1)
                continue;

            ss = getLP(s, i, i + 1);
            if (ss[1] - ss[0] > res[1] - res[0])
                res = ss;
        }

        return s.substring(res[0], res[1]);
    }
}
