class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    public MinStack() {
        this.st = new Stack<>();
        this.minSt = new Stack<>();
    }
    
    public void push(int value) {
        st.push(value);
        if (minSt.isEmpty() || value <= minSt.peek()) {
            minSt.push(value);
        }
        //System.out.println(st);
    }
    
    public void pop() {
        int val = st.pop();
        if (!minSt.isEmpty() && minSt.peek() == val) {
            minSt.pop();
        }
        //System.out.println("pop: "+st);
    }
    
    public int top() {
        //System.out.println("top "+st.peek());
        return st.peek();
    }
    
    public int getMin() {
        return minSt.isEmpty() ? 0 : minSt.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */