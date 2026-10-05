class Node {
    int key, val;
    Node next, prev;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    Map<Integer, Node> hm;
    int capacity;
    Node head, tail;
    public LRUCache(int capacity) {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.hm = new HashMap<>();
        this.capacity = capacity;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if (hm.containsKey(key)) {
            Node node = hm.get(key);
            moveInFront(node);
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (hm.containsKey(key)) {
            Node node = hm.get(key);
            node.val = value;
            moveInFront(node);
            return;
        }

        if (hm.size() == capacity) {
            Node node = tail.prev;
            deleteNode(node);
            hm.remove(node.key);
        }
        Node node = new Node(key, value);
        hm.put(key, node);
        addInFront(node);
    }

    void moveInFront(Node node) {
        deleteNode(node);
        addInFront(node);
    }

    void deleteNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    void addInFront(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */