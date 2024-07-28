class LRUCache {
    Map<Integer, Integer> hm;
    int cap;
    public LRUCache(int capacity) {
        this.hm = new LinkedHashMap<>();
        this.cap = capacity;
    }
    
    public int get(int key) {
        if (hm.containsKey(key)) {
            int val = hm.remove(key);
            hm.put(key, val);
            return val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (hm.containsKey(key)) {
            hm.remove(key);
        }
        if (hm.size() >= cap) {
            int remKey = 0;
            boolean flag = false;
            for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
                remKey = e.getKey();
                flag = true;
                break;
            }
            if (flag) {
                hm.remove(remKey);
            }
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