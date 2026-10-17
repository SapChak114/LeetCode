/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> hm = new HashMap<>();

        Node curr = head;
        Node dummy = new Node(0);
        
        while (curr != null) {
            Node nNode = new Node(curr.val);
            hm.put(curr, nNode);
            dummy.next = nNode;
            dummy = dummy.next;
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node nNode = hm.get(curr);
            nNode.random = hm.get(curr.random);
            curr = curr.next;
        }

        return hm.get(head);
    }
}