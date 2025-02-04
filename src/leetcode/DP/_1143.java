package leetcode.DP;

import java.util.*;

public class _1143
{
    private void getAllCombos(String str, HashSet<String> set, int i)
    {
        set.add(str);

        if (i >= str.length())
            return;

        getAllCombos(str, set, i + 1);
        getAllCombos(str.substring(0, i) + str.substring(i + 1), set, i);
    }

    public int longestCommonSubsequence(String text1, String text2)
    {
        HashSet<Character> set1 = new HashSet<>();
        for (int i = 0; i < text1.length(); i++)
            set1.add(text1.charAt(i));

        HashSet<Character> set2 = new HashSet<>();

        for (int i = 0; i < text2.length(); i++) {
            char ch = text2.charAt(i);
            if (!set1.contains(ch)) {
                text2 = text2.substring(0, i) + text2.substring(i + 1);
                i--;
                continue;
            }

            set2.add(ch);
        }

        for (int i = 0; i < text1.length(); i++) {
            char ch = text1.charAt(i);
            if (set2.contains(ch))
                continue;

            text1 = text1.substring(0, i) + text1.substring(i + 1);
            i--;
            set1.remove(ch);
        }

        System.out.printf("st1: %s\n", text1);
        System.out.printf("st2: %s\n", text2);

        if (text1.equals(text2))
            return text1.length();

        int lcs = 0;

        // u, p, r, up, ur, pr, upr
        // 2^n + 2^m + (2n + m)


        System.out.printf("%b\n", text1.equals(text2));

        HashSet<String> combo1 = new HashSet<>();
        getAllCombos(text1, combo1, 0);
        HashSet<String> combo2 = new HashSet<>();
        getAllCombos(text2, combo2, 0);

        System.out.printf("%s\n", combo1.toString());
        System.out.printf("%s\n", combo2.toString());

        for (String s : combo1) {
            if (combo2.contains(s))
                lcs = Math.max(lcs, s.length());
        }


        return lcs;
    }
}
