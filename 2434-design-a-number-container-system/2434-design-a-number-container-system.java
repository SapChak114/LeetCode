class NumberContainers {

    private Map<Integer, TreeSet<Integer>> numberToIndex;
    private Map<Integer, Integer> indexToNumbers;


    public NumberContainers() {
        this.numberToIndex = new HashMap<>();
        this.indexToNumbers = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if (indexToNumbers.containsKey(index)) {
            numberToIndex.get(indexToNumbers.get(index)).remove(index);
            if (numberToIndex.get(indexToNumbers.get(index)).isEmpty()) {
                numberToIndex.remove(indexToNumbers.get(index));
            }
        }

        indexToNumbers.put(index, number);
        numberToIndex.putIfAbsent(number, new TreeSet<>());
        numberToIndex.get(number).add(index);
    }
    
    public int find(int number) {
        if (numberToIndex.containsKey(number)) {
            return numberToIndex.get(number).first();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */