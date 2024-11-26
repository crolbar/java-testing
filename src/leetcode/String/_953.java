package leetcode.String;

import java.util.HashMap;

public
class _953
{
  public
    boolean isAlienSorted(String[] words, String order)
    {
        HashMap<Character, Integer> alpha = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            alpha.put(c, i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word = words[i];
            String word2 = words[i + 1];

            for (int j = 0; j < word.length(); j++) {
                if (j >= word2.length()) {
                    return false;
                }

                char c = word.charAt(j);
                char c2 = word2.charAt(j);
                if (c == c2)
                    continue;

                if (alpha.get(c) > alpha.get(c2))
                    return false;

                break;
            }
        }

        return true;
    }
}
