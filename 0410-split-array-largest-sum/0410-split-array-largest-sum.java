class Solution {
    public int splitArray(int[] nums, int k) {
        int maxNum=0;
        long sum = 0;
        for(int num : nums){
            maxNum = Math.max(maxNum,num);
            sum += num;
        }
        int l = maxNum, r = (int)(sum+1);
        while(l<r){
            int mid = l + (r-l)/2;
            if(canWork(nums,k,mid)){
                r = mid;
            } else{
                l = mid+1;
            }
        }
        return l;
    }

    private boolean canWork(int[] nums, int k, int cap){
        int cur = 0;
        int split = 1;
        for(int num : nums){
            if(num+cur > cap){
                split++;
                cur = 0;
                if(split>k) return false;
            }
            cur += num;
        }
        return true;
    }
}