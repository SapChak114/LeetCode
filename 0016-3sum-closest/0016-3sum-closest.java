class Solution {
    public int threeSumClosest(int[] nums, int targ) {
        Arrays.sort(nums);
        int nSum = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length; i++){
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int mid = j + (k-j)/2;
                int sum = nums[i]+nums[j]+nums[k];
                if(Math.abs(sum-targ)<Math.abs(nSum-targ)){
                    nSum = sum;
                }
                else if(sum<targ){
                    j++;
                } else{
                    k--;
                }
            }
        }
        
        return nSum;
    }
}