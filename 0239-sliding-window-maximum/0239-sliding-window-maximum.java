class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        
        if(n==1){
            return new int[]{nums[0]};
        }
        
        Deque<Integer> q = new LinkedList<>();
        int[] ans = new int[n-k+1];
        int idx = 0;
        
        for(int i = 0; i<n; i++){
            
            while(!q.isEmpty() && q.peekFirst()<i-k+1){
                q.pollFirst();
            }
            
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i]){
                q.pollLast();
            }
            
            q.add(i);
            
            if(i>=k-1){
                ans[idx++] = nums[q.peekFirst()];
            }
        }
        
        return ans;
    }
}