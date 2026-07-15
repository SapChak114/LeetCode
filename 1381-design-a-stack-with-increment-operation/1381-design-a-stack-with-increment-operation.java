class CustomStack {
    List<Integer> st;
    List<Integer> inc;
    int n;
    public CustomStack(int maxSize) {
        this.n = maxSize;
        this.st = new ArrayList<>();
        this.inc = new ArrayList<>();
    }
    
    public void push(int x) {
        if (st.size() < n) {
            st.add(x);
            inc.add(0);
        }
    }
    
    public int pop() {
        if (st.size() > 0) {
            int val = st.get(st.size()-1);
            st.remove(st.size()-1);
            int in = inc.get(inc.size()-1);
            inc.remove(inc.size()-1);
            if (inc.size() > 0) {
                inc.set(inc.size()-1, inc.get(inc.size()-1)+in);
            }
            return val + in;
        } else {
            return -1;
        }
    }
    
    public void increment(int k, int val) {
        if (st.isEmpty()) {
            return;
        }
        int idx = Math.min(k, st.size())-1;
        inc.set(idx, inc.get(idx) + val);
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */