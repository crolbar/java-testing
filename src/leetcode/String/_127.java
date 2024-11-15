package leetcode.String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public
class _127
{
    int getDiff(String str1, String str2)
    {
        int diff = 0;

        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (c1 != c2)
                diff++;
        }

        return diff;
    }

    int bfs(Queue<Integer> q,
            List<List<Integer>> adj,
            HashSet<Integer> visited,
            int c,
            String endWord,
            List<String> wordList)
    {
        while (!q.isEmpty()) {
            c++;
            for (int i = 0, size = q.size(); i < size; i++) {
                Integer curr = q.poll();
                visited.add(curr);

                if (wordList.get(curr).equals(endWord))
                    return c + 1;

                for (Integer nei : adj.get(curr)) {
                    if (visited.contains(nei))
                        continue;

                    q.add(nei);
                }
            }
        }

        return 0;
    }

  public
    int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        List<List<Integer>> adj = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();

        for (int i = 0; i < wordList.size(); i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);

            for (int j = i + 1; j < wordList.size(); j++) {
                String word2 = wordList.get(j);

                int diff = getDiff(word, word2);

                if (diff == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);

            int diff = getDiff(beginWord, word);

            if (diff == 1) {
                q.add(i);
            }
        }

        System.out.println(adj);
        System.out.println(q);

        return bfs(q, adj, visited, 0, endWord, wordList);
    }
}
