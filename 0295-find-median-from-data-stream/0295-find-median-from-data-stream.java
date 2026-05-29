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
            heapAdd(smallHeap, largeHeap);
        }

        if (smallHeap.size() > (largeHeap.size() + 1)) {
            heapAdd(smallHeap, largeHeap);
        }

        if (largeHeap.size() > (smallHeap.size() + 1)) {
            heapAdd(largeHeap, smallHeap);
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

    void heapAdd(PriorityQueue<Integer> heap1, PriorityQueue<Integer> heap2) {
        heap2.add(heap1.poll());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */