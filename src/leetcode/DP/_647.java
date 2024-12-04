package leetcode.DP;

public
class _647
{
  private
    int manacher(String s)
    {
        StringBuilder sb = new StringBuilder("|");
        for (char c : s.toCharArray()) {
            sb.append(c).append("|");
        }

        int[] p = new int[sb.length()];

        int c = 0;
        int l = 0;
        int r = 0;
        for (int i = 0; i < sb.length(); i++) {
            p[i] = (i < r) ? Math.min(r - i, p[l + (r - i)]) : 0;

            c += (p[i] + 1) / 2;

            while (i - p[i] - 1 >= 0 && i + p[i] + 1 < sb.length() &&
                   sb.charAt(i - p[i] - 1) == sb.charAt(i + p[i] + 1)) {

                if (sb.charAt(i - p[i]) != '|') {
                    c++;
                }

                p[i]++;
            }

            if (i + p[i] > r) {
                l = i - p[i];
                r = i + p[i];
            }
        }

        return c;
    }

  public
    int countSubstrings(String s) { return manacher(s); }
}
