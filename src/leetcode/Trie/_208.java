package leetcode.Trie;

import java.util.HashMap;

public class _208 {
    Trie t;

    _208() {
        this.t = new Trie();
    }
}

class Trie {
    class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isEndOfWord;

        TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }

        @Override
        public String toString() {
            return String.format("children: %s, %d", children.toString(), isEndOfWord ? 1 : 0);
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
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

        System.out.println(this.root.children);
    }
    
    public boolean search(String word) {
        TrieNode curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }

        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }

        return curr.isEndOfWord;
    }
}
