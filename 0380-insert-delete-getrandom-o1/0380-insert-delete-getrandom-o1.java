class RandomizedSet {
    Map<Integer, Integer> numMap;
    List<Integer> numList;
    public RandomizedSet() {
        this.numMap = new HashMap<>();
        this.numList = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        boolean isNotPresent = !numMap.containsKey(val);
        if (isNotPresent) {
            this.numMap.put(val, this.numList.size());
            this.numList.add(val);
        }

        return isNotPresent;
    }
    
    public boolean remove(int val) {
        boolean isPresent = numMap.containsKey(val);
        if (isPresent) {
            // requirements
            int idx = this.numMap.get(val);
            int lastVal = this.numList.get(this.numList.size() - 1);
            int lastIdx = this.numList.size()-1;

            // delete ops
            this.numMap.put(lastVal, idx);
            this.numMap.remove(val);
            this.numList.set(idx, lastVal);
            this.numList.remove(this.numList.size()-1);
        }

        return isPresent;
    }
    
    public int getRandom() {
        Random r = new Random();
        return this.numList.get(r.nextInt(this.numList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */