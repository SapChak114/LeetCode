class MedianFinder {
    PriorityQueue<Integer> smallHeap;
    PriorityQueue<Integer> largeHeap;
    public MedianFinder() {
        this.smallHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.largeHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        smallHeap.add(num);
        if (!largeHeap.isEmpty() && smallHeap.peek() > largeHeap.peek()) {
            int large = smallHeap.poll();
            largeHeap.add(large);
        }

        if (smallHeap.size() > (largeHeap.size() + 1)) {
            int large = smallHeap.poll();
            largeHeap.add(large);
        }

        if (largeHeap.size() > (smallHeap.size() + 1)) {
            int small = largeHeap.poll();
            smallHeap.add(small);
        }
    }
    
    public double findMedian() {
        if (smallHeap.size() > largeHeap.size()) {
            return (double)smallHeap.peek();
        } else if (largeHeap.size() > smallHeap.size()) {
            return (double)largeHeap.peek();
        } else {
            int large = smallHeap.peek();
            int small = largeHeap.peek();
            return ((double) large + small) / 2.0d;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */