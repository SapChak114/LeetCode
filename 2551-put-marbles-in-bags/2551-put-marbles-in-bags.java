class Solution {
    public long putMarbles(int[] w, int k) {
        if(k==1) return 0;
        
        List<Integer> li = new ArrayList<>();
        for(int i = 1; i<w.length; i++){
            li.add(w[i]+w[i-1]);
        }
        int n = li.size();
        Collections.sort(li);
        
        long l = 0, r = 0;
        for(int i = 0; i+1<k; i++){
            l += li.get(i);
            r += li.get(n-i-1);
        }
        
        return r-l;
    }
}