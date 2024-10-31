package leetcode.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public
class _212
{

    int[][] dirs = new int[][]{
        { -1, 0 }, // up
        { 0, 1 },  // right
        { 1, 0 },  // dow
        { 0, -1 }, // left
    };

    void r(char[][] board,
              List<String> res,
              Trie trie,
              StringBuilder currword,
              boolean[][] seen,
              int y,
              int x)
    {
        if (seen[y][x])
            return;

        if (!trie.startsWith(currword.toString() + board[y][x]))
            return;

        seen[y][x] = true;

        currword.append(board[y][x]);

        if (trie.search(currword.toString())) {
            String word = currword.toString();
            res.add(word);
            trie.deleteWord(word);
        }

        for (int i = 0; i < dirs.length; i++) {
            int[] dir = dirs[i];
            int newY = clamp(y + dir[0], 0, board.length - 1);
            int newX = clamp(x + dir[1], 0, board[0].length - 1);

            r(board, res, trie, currword, seen, newY, newX);
        }

        currword.deleteCharAt(currword.length() - 1);

        seen[y][x] = false;
    }

    int clamp(int val, int min, int max)
    {
        return Math.min(Math.max(val, min), max);
    }

  public
    List<String> findWords(char[][] board, String[] words)
    {
        List<String> res = new ArrayList<>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        boolean[][] seen = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                r(board, res, trie, new StringBuilder(), seen, i, j);
            }
        }

        return res;
    }

    class Trie
    {
        class TrieNode
        {
            HashMap<Character, TrieNode> children;
            boolean isEndOfWord;
            int ref;

            TrieNode()
            {
                children = new HashMap<>();
                isEndOfWord = false;
                ref = 0;
            }

            @Override public String toString()
            {
                return String.format(
                  "children: %s, %d", children.toString(), isEndOfWord ? 1 : 0);
            }
        }

        TrieNode root;

      public
        Trie() { root = new TrieNode(); }

      public
        void insert(String word)
        {
            TrieNode curr = this.root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (!curr.children.containsKey(c)) {
                    TrieNode node = new TrieNode();
                    curr.children.put(c, node);
                }

                curr = curr.children.get(c);

                curr.ref++;
            }
            curr.isEndOfWord = true;
        }

      public
        boolean search(String word)
        {
            TrieNode curr = this.root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (!curr.children.containsKey(c))
                    return false;

                curr = curr.children.get(c);
            }

            return curr.isEndOfWord;
        }

      public
        boolean startsWith(String prefix)
        {
            TrieNode curr = this.root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);

                if (!curr.children.containsKey(c))
                    return false;

                curr = curr.children.get(c);

                if (curr.ref <= 0)
                    return false;
            }

            return true;
        }

      public
          void deleteWord(String word) {
            TrieNode curr = this.root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (!curr.children.containsKey(c))
                    return;

                curr = curr.children.get(c);

                curr.ref--;
            }

            curr.isEndOfWord = false;
          }
    }
}
