package leetcode.Math;

public
class _67
{
  public
    String addBinary(String a, String b)
    {
        StringBuilder res = new StringBuilder();

        int maxLen = Math.max(a.length(), b.length());

        int has_rem = 0;
        for (int i = 0; i < maxLen || has_rem > 0; i++) {
            int eval = has_rem;

            eval +=
              ((i < a.length()) ? (a.charAt(a.length() - 1 - i) - '0') : 0) +
              ((i < b.length()) ? (b.charAt(b.length() - 1 - i) - '0') : 0);

            res.append(eval % 2);
            has_rem = eval / 2;
        }

        return res.reverse().toString();
    }
}
