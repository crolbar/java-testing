package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

public
class _131
{
    boolean isPalindrome(String s, int l, int r)
    {
        do {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }

            r--;
            l++;
        } while (l < r);

        return true;
    }

    void r(List<List<String>> res, ArrayList<String> l, String s, int i)
    {
        if (i >= s.length())
            res.add(new ArrayList<>(l));

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                l.add(s.substring(i, j + 1));
                r(res, l, s, j + 1);
                l.removeLast();
            }
        }
    }

  public
    List<List<String>> partition(String s)
    {
        List<List<String>> res = new ArrayList<>();
        r(res, new ArrayList<>(), s, 0);
        return res;
    }
}
