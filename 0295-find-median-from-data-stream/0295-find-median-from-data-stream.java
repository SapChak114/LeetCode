class MedianFinder {
    PriorityQueue<Integer> leftMaxHeap;
    PriorityQueue<Integer> rightMinHeap;
    public MedianFinder() {
        this.leftMaxHeap = new PriorityQueue<>((a, b) -> b - a);
        this.rightMinHeap = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {
        leftMaxHeap.add(num);
        rightMinHeap.add(leftMaxHeap.poll());

        if (leftMaxHeap.size() < rightMinHeap.size()) {
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }
    
    public double findMedian() {
        if (leftMaxHeap.size() > rightMinHeap.size()) {
            return leftMaxHeap.peek();
        }

        return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */