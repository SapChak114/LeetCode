class SnapshotArray {
    public List<int[]>[] h;
    public int snap = 0;
    public SnapshotArray(int length) {
        h = new List[length];
        for (int i = 0; i < length; i++) {
            h[i] = new ArrayList<>();
            // add an initial [snap_id, val] pair, very important
            h[i].add(new int[]{-1, 0});
        }
    }
    
    public void set(int index, int val) {
        h[index].add(new int[]{snap, val});
    }
    
    public int snap() {
        return snap++;
    }
    
    public int get(int index, int snap_id) {
        List<int[]> temp = h[index];
        int l = 0, r = temp.size() - 1;
        // binary search rightmost
        while (l < r) {
            int m = r - (r - l) / 2;
            if (temp.get(m)[0] <= snap_id) l = m;
            else r = m - 1;
        }
        return temp.get(l)[1];
    }
}
/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */