package leetcode.Graph;
import java.util.HashMap;
import java.util.HashSet;

import leetcode.lib.Graph.*;

public class _133 {
    void r(Node curr, Node origin, HashMap<Integer, Node> lookup, HashSet<Integer> visited) {
        if (visited.contains(curr.val)) {
            return;
        }

        visited.add(curr.val);
        for (int i = 0; i < origin.neighbors.size(); i++) {
            Node n = origin.neighbors.get(i);

            if (!lookup.containsKey(n.val)) {
                lookup.put(n.val, new Node(n.val));
            }

            curr.neighbors.add(lookup.get(n.val));

            r(lookup.get(n.val), n, lookup, visited);
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) 
            return null;

        HashMap<Integer, Node> lookup = new HashMap<>();

        lookup.put(node.val, new Node(node.val));
        Node root = lookup.get(node.val);

        r(root, node, lookup, new HashSet<>());

        return root;
    }
}
