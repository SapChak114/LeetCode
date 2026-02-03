class LRUCache {
    LinkedHashMap<Integer, Integer> hm;
    int cap;
    public LRUCache(int capacity) {
        this.hm = new LinkedHashMap<>();
        this.cap = capacity;
    }
    
    public int get(int key) {
        if (!hm.containsKey(key)) {
            return -1;
        }

        int val = hm.remove(key);
        hm.put(key, val);
        return val;
    }
    
    public void put(int key, int value) {
        if (hm.containsKey(key)) {
            hm.remove(key);
        }

        if (hm.size() >= cap) {
            hm.remove(hm.keySet().iterator().next());
        }

        hm.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */