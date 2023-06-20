class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        int start = 0;
        long sum = 0;
        long ops = 2*k+1;
        for(int end = 0; end<n; end++){
            sum += nums[end];
            if(end-start+1 == ops){
                res[end-k] = (int)(sum/ops);
                sum -= nums[start];
                start++;
            }
        }
        
        return res;
    }
}