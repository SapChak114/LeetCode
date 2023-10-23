class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        pq.add(new int[]{nums[0],0});
        
        int n = nums.length, ans = nums[0], curr = 0;
        
        for(int i = 1; i<n; i++){
            while(i-pq.peek()[1]>k) pq.poll();
            
            curr = Math.max(0,pq.peek()[0]) + nums[i];
            ans = Math.max(curr,ans);
            pq.add(new int[]{curr,i});
        }
        
        return ans;
        
    }
}