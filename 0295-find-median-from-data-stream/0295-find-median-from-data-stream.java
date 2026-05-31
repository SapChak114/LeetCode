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
            largeHeap.add(smallHeap.poll());
        }

        if (smallHeap.size() > (largeHeap.size() + 1)) {
            largeHeap.add(smallHeap.poll());
        }

        if (largeHeap.size() > (smallHeap.size() + 1)) {
            smallHeap.add(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        if (smallHeap.size() > largeHeap.size()) {
            return smallHeap.peek();
        }

        if (largeHeap.size() > smallHeap.size()) {
            return largeHeap.peek();
        }

        return ((double) smallHeap.peek() + largeHeap.peek()) / 2.0d;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */