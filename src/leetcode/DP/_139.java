package leetcode.DP;

import java.util.HashMap;
import java.util.List;

public
class _139
{
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
    }

    public boolean
    wordBreak(String s, List<String> wordDict)
    {
        Trie trie = new Trie();
        for (String word : wordDict) {
            trie.insert(word);
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < Math.min(i + maxLen, s.length()); j++) {
                if (trie.search(s.substring(i, j + 1))) {
                    dp[i] = dp[j + 1];
                    if (dp[i])
                        break;
                }
            }
        }

        return dp[0];
    }
}
