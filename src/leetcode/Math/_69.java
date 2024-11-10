package leetcode.Math;
public
class _69
{
  public
    int mySqrt(int x)
    {
        if (x == 0 || x == 1)
            return x;

        int l = 1, r = x;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if ((long)m * m > (long)x) {
                r = m - 1;
            } else if (m * m < x) {
                l = m + 1;
            } else {
                return m;
            }
        }

        return Math.round(r);
    }
}
