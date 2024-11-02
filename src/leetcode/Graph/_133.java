package leetcode.Graph;
import java.util.HashMap;
import leetcode.lib.Graph.*;

public class _133 {
    void r(Node curr, Node origin, HashMap<Integer, Node> lookup) {
        for (int i = 0; i < origin.neighbors.size(); i++) {
            Node oldNeighbor = origin.neighbors.get(i);

            if (!lookup.containsKey(oldNeighbor.val)) {
                Node newNeighbor = new Node(oldNeighbor.val);

                lookup.put(oldNeighbor.val, newNeighbor);
                r(newNeighbor, oldNeighbor, lookup);
            }

            curr.neighbors.add(lookup.get(oldNeighbor.val));
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) 
            return null;

        HashMap<Integer, Node> lookup = new HashMap<>();

        lookup.put(node.val, new Node(node.val));
        Node root = lookup.get(node.val);

        r(root, node, lookup);

        return root;
    }
}
