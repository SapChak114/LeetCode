class LRUCache {
    
    class Node{
        int key;
        int val;
        Node next;
        Node prev;
        
        public Node(int key, int val){
            this.key=key;
            this.val=val;
        }    
    }
    
    Map<Integer,Node> m = new HashMap<>();
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int cap;
    
    public LRUCache(int capacity) {
        this.cap=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public void delNode(Node delNode){
        Node next = delNode.next;
        Node prev = delNode.prev;
        
        prev.next = next;
        next.prev = prev;
    }
    
    public void addNode(Node newNode){
        Node temp = head.next;
        
        newNode.next = temp;
        newNode.prev = head;
        
        head.next = newNode;
        temp.prev = newNode;
        
    }
    public int get(int key) {
        if(m.containsKey(key)){
            Node node = m.get(key);
            int ans = node.val;
            
            m.remove(key);
            delNode(node);
            addNode(node);
            m.put(key,head.next);
            return ans;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(m.containsKey(key)){
            Node node = m.get(key);
            m.remove(key);
            delNode(node);
        }
        
        if(m.size()==cap){
            m.remove(tail.prev.key);
            delNode(tail.prev);
        }
        
        addNode(new Node(key,value));
        m.put(key,head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */