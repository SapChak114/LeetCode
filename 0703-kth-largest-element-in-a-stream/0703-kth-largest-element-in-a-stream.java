class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k=k;
        for(int a : nums) pq.add(a);
        while(pq.size()>k) pq.poll();
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size()>k) pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */