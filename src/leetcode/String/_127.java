package leetcode.String;

import java.util.*;

public
class _127
{
    int bfs(Queue<String> q,
            HashMap<String, List<String>> adj,
            HashSet<String> visited,
            String endWord)
    {
        int c = 0;

        while (!q.isEmpty()) {
            c++;
            for (int i = 0, size = q.size(); i < size; i++) {
                String curr = q.poll();

                if (curr.equals(endWord))
                    return c;

                for (int j = 0; j < curr.length(); j++) {
                    String pattern =
                      curr.substring(0, j) + "*" + curr.substring(j + 1);

                    List<String> neis =
                      adj.getOrDefault(pattern, Collections.emptyList());

                    for (String nei : neis) {
                        if (visited.contains(nei))
                            continue;

                        visited.add(nei);
                        q.add(nei);
                    }
                }
            }
        }

        return 0;
    }

  public
    int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        if (!wordList.contains(endWord))
            return 0;

        HashMap<String, List<String>> adj = new HashMap<>();

        wordList.add(beginWord);
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String p = word.substring(0, i) + '*' + word.substring(i + 1);
                adj.computeIfAbsent(p, k->new ArrayList<>()).add(word);
            }
        }

        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);

        return bfs(q, adj, visited, endWord);
    }
}
