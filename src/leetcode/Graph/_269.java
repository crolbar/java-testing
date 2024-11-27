package leetcode.Graph;
import java.util.HashMap;
import java.util.HashSet;

public
class _269
{

  private
    boolean dfs(HashMap<Character, HashSet<Character>> adj,
                HashMap<Character, Boolean> visited,
                StringBuilder res,
                Character c)
    {
        if (visited.containsKey(c))
            return visited.get(c);

        visited.put(c, true);

        for (Character nei : adj.get(c)) {
            if (dfs(adj, visited, res, nei))
                return true;
        }

        visited.put(c, false);
        res.append(c);

        return false;
    }

  public
    String foreignDictionary(String[] words)
    {
        HashMap<Character, HashSet<Character>> adj = new HashMap<>();

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                adj.put(word.charAt(i), new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            int size = Math.min(word1.length(), word2.length());

            if (word1.length() > word2.length()) {
                if (word1.substring(0, size).equals(word2.substring(0, size)))
                    return "";
            }

            for (int j = 0; j < size; j++) {
                if (word1.charAt(j) == word2.charAt(j))
                    continue;

                adj.get(word1.charAt(j)).add(word2.charAt(j));
                break;
            }
        }

        HashMap<Character, Boolean> visited = new HashMap<>();
        StringBuilder res = new StringBuilder();

        for (Character c : adj.keySet()) {
            if (dfs(adj, visited, res, c))
                return "";
        }

        return res.reverse().toString();
    }
}
