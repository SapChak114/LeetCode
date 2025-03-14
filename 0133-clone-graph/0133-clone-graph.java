/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> vis;
    public Node cloneGraph(Node node) {
        this.vis = new HashMap<>();

        return clone(node);
    }

    Node clone(Node node) {
        if (node == null) {
            return null;
        }

        if (vis.containsKey(node)) {
            return vis.get(node);
        }

        Node nod = new Node(node.val);

        vis.put(node, nod);

        for (Node n : node.neighbors) {
            nod.neighbors.add(clone(n));
        }

        return nod;
    }
}