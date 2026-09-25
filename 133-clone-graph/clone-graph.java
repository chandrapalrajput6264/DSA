import java.util.*;

class Solution {
    private final Map<Node, Node> cloned = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // Already cloned
        if (cloned.containsKey(node)) {
            return cloned.get(node);
        }

        // Create clone before visiting neighbors
        Node copy = new Node(node.val);
        cloned.put(node, copy);

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor));
        }

        return copy;
    }
}