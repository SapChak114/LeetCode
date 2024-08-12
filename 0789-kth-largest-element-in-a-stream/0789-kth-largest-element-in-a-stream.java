class KthLargest {
    List<Integer> list;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.list = new ArrayList<>();
        //System.out.println(Arrays.toString(nums));
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list, Collections.reverseOrder());
    }
    
    public int add(int val) {
        list.add(val);
        Collections.sort(list, Collections.reverseOrder());
        return list.get(k-1);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */