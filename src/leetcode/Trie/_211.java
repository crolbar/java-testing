package leetcode.Trie;

import java.util.HashMap;

public
class _211
{
    WordDictionary t;

    _211() { this.t = new WordDictionary(); }
}

class WordDictionary
{
    class TrieNode
    {
        HashMap<Character, TrieNode> children;
        boolean isEndOfWord;

        TrieNode()
        {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }
    }

    TrieNode root;

  public
    WordDictionary() { this.root = new TrieNode(); }

  public
    void addWord(String word)
    {
        TrieNode curr = this.root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!curr.children.containsKey(c)) {
                TrieNode node = new TrieNode();
                curr.children.put(c, node);
            }

            curr = curr.children.get(c);
        }

        curr.isEndOfWord = true;
    }

  public
    boolean search(String word) { return dfs(word, 0, this.root); }

  private
    boolean dfs(String word, int idx, TrieNode curr)
    {
        for (int i = idx; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == '.') {
                for (TrieNode n : curr.children.values()) {
                    if (dfs(word, i + 1, n)) {
                        return true;
                    }
                }
            }

            if (!curr.children.containsKey(c)) {
                return false;
            }

            curr = curr.children.get(c);
        }

        return curr.isEndOfWord;
    }
}
