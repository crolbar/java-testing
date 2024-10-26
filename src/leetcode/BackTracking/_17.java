package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

public
class _17
{
    String[] telephone = new String[]{
        "", "abc", "def",
        "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz",
    };

    void r(String digits, List<String> res, StringBuilder curr, int i)
    {
        if (i >= digits.length()) {
            res.add(curr.toString());
            return;
        }

        String letters = telephone[(digits.charAt(i) - '0') - 1];
        for (int j = 0; j < letters.length(); j++) {
            curr.append(letters.charAt(j));
            r(digits, res, curr, i + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

  public
    List<String> letterCombinations(String digits)
    {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        r(digits, res, new StringBuilder(), 0);
        return res;
    }
}
