package pkgs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Trie {
    public static void main() {
        Trie trie = new Trie();

        trie.insert("foo");
        trie.insert("fool");
        trie.insert("foolish");
        trie.insert("bar");

        String[] s = new String[3];
        s[0] = "foo";
        s[1] = "fool";
        s[2] = "foolish";

        assert Arrays.equals(trie.find("fo"), s);

        trie.delete("fool");

        s = new String[2];
        s[0] = "foo";
        s[1] = "foolish";

        assert Arrays.equals(trie.find("fo"), s);



        trie.insert("helicopter");
        trie.insert("hellium");
        trie.insert("hololo");
        trie.insert("hello");

        assert trie.contains("foo");

        trie.delete("hello");
        assert !trie.contains("hello");

        s = new String[2];
        s[0] = "helicopter";
        s[1] = "hellium";

        assert Arrays.equals(trie.find("he"), s);
        System.out.println("testing Trie successful");
    }

    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode curr = this.root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!curr.children.containsKey(c)) {
                TrieNode n = new TrieNode();
                curr.children.put(c, n);
            }

            curr = curr.children.get(c);
        }

        curr.isWord = true;
    }

    boolean contains(String word) {
        TrieNode curr = this.root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!curr.children.containsKey(c)) {
                return false;
            }

            curr = curr.children.get(c);
        }

        return curr.isWord;
    }

    // TODO: actualy delete them
    // private void delete_r(TrieNode curr, String word) { if (curr.isWord) return; }
    void delete(String word) {
        if (!this.contains(word)) return;

        TrieNode curr = this.root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            curr = curr.children.get(c);
        }

        curr.isWord = false;
    }

    private void _find_r(ArrayList<String> list, TrieNode curr, String prefix) {
        if (curr.isWord) list.add(prefix);

        TrieNode[] nodes = curr.children.values().toArray(new TrieNode[0]);
        Character[] chars = curr.children.keySet().toArray(new Character[0]);
        for (int i = 0; i < nodes.length; i++) {
            _find_r(list, nodes[i], prefix + chars[i]);
        }
    }

    String[] find(String prefix) {
        ArrayList<String> list = new ArrayList<>();

        TrieNode curr = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            curr = curr.children.get(c);
        }

        _find_r(list, curr, prefix);

        String[] out = new String[list.size()];
        for (int i = 0; i < list.size(); i++) out[i] = list.get(i);
        return out;
    }

    class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean isWord;

        TrieNode() {
            children = new HashMap<>();
            isWord = false;
        }
    }
}
