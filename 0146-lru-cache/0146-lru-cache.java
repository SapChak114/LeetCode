class LRUCache {
    
    Map<Integer,Integer> map;
    int cap;
    
    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity);
        cap = capacity;    
    }
    
    public int get(int key) {
        Integer val = map.get(key);
        if(val==null){
            return -1;
        } else{
            map.remove(key);
            map.put(key,val);
            return val;
        }
    }
    
    public void put(int key, int value) {
        Integer val = map.get(key);
        if(val!=null){
            map.remove(key);
            map.put(key,value);
        } else {
            if(map.size()==cap){
                Integer last = null;
                for(int k : map.keySet()){
                    last = k;
                    break;
                }
                map.remove(last);
            }
            map.put(key,value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */