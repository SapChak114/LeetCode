class Node {
    Node next, prev;
    int key, val;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    Node tail, head;
    Map<Integer, Node> map;
    int capacity;
    
    public LRUCache(int capacity) {
        tail = new Node(-1, -1);
        head = new Node(-1, -1);
        map = new HashMap<>();
        this.capacity = capacity;

        tail.prev = head;
        head.next = tail;
    }
    public void put(int key, int val) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = val;
            moveInFront(node);
            return;
        }

        if (map.size() == capacity) {
            Node node = tail.prev;
            delete(node);
            map.remove(node.key);
        }

        Node node = new Node(key, val);
        map.put(key, node);
        addInFront(node);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            moveInFront(node);
            return node.val;
        } else {
            return -1;
        }
    }

    private void moveInFront(Node node) {
        delete(node);
        addInFront(node);
    }

    private void addInFront(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void delete(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */