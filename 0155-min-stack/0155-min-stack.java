class MinStack {
    Stack<Integer> minSt;
    Stack<Integer> st;
    public MinStack() {
        this.minSt = new Stack<>();
        this.st = new Stack<>();
    }
    
    public void push(int value) {
        st.push(value);

        if (!minSt.isEmpty() && value <= minSt.peek()) {
            minSt.push(value);
        } else if (minSt.isEmpty()){
            minSt.push(value);
        }
    }
    
    public void pop() {
        if (st.isEmpty()) {
            return;
        }
        int val = st.pop();

        if (minSt.peek() == val) {
            minSt.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return  minSt.peek();
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