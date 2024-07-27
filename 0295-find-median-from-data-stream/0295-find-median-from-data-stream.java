class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>((a, b) -> b-a);
        this.minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // minHeap.add(num);
        
        // while (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
        //     minHeap.add(maxHeap.poll());
        // }

        // while (minHeap.size() > maxHeap.size()) {
        //     maxHeap.add(minHeap.poll());
        // }

        if (minHeap.size() == maxHeap.size()) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        } else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (double)(maxHeap.peek() + minHeap.peek())/2;
        } else {
            return minHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */