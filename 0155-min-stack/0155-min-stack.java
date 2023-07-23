class MinStack {
    Stack<Integer> st;
    Map<Integer,Integer> map;
    public MinStack() {
        st = new Stack<>();
        map = new TreeMap<>();
    }
    
    public void push(int val) {
        map.put(val,map.getOrDefault(val,0)+1);
        st.add(val);
    }
    
    public void pop() {
        int val = map.get(st.peek());
        if(val==1){
            map.remove(st.peek());
        } else{
            map.put(st.peek(),map.get(st.peek())-1);
        }
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        for(int x : map.keySet()) return x;
        return 0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */