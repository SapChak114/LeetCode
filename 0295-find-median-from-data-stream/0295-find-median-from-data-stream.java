class MedianFinder {
    PriorityQueue<Integer> leftMax;
    PriorityQueue<Integer> rightMin;
    public MedianFinder() {
        this.leftMax = new PriorityQueue<>(Collections.reverseOrder());
        this.rightMin = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        this.leftMax.add(num);
        rightMin.add(leftMax.poll());
        if (leftMax.size() < rightMin.size()) {
            leftMax.add(rightMin.poll());
        }
    }
    
    public double findMedian() {
        if (leftMax.size() > rightMin.size()) {
            return leftMax.peek();
        }
        return (leftMax.peek() + rightMin.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */