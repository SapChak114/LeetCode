/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Pair<Integer, Node>> q = new LinkedList<>();
        Map<Integer, List<Node>> map = new HashMap<>();

        q.add(new Pair(0, root));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int level = (int)p.getKey();
            Node node = (Node)p.getValue();

            map.computeIfAbsent(level,o -> new ArrayList<>()).add(node);

            if (node.left != null) {
                q.add(new Pair(level + 1, node.left));
            }

            if (node.right != null) {
                q.add(new Pair(level + 1, node.right));
            }
        }

        for (List<Node> nodes : map.values()) {
            for (int i = 0; i<nodes.size()-1; i++) {
                nodes.get(i).next = nodes.get(i+1);
            }
        }

        return root;
    }
}