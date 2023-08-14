class Solution {
    Boolean[] dp;
    public boolean validPartition(int[] nums) {
        dp = new Boolean[nums.length+1];
        return isValid(nums,0);
    }
   
    boolean isValid(int[] nums, int idx){
        int n = nums.length;
        if(idx>=n){
            return true;
        }
        if(nums.length<1){
            return false;
        }
        
        if(dp[idx]!=null) return dp[idx];
        
        List<Integer> sub1 = new ArrayList<>();
        for(int k = idx; k<idx+2 && k<n; k++){
            sub1.add(nums[k]);
        }
        
        List<Integer> sub2 = new ArrayList<>();
        for(int k = idx; k<idx+3 && k<n; k++){
            sub2.add(nums[k]);
        }
        
        if(check(sub1) && isValid(nums,idx+2)){
            return dp[idx]=true;
        }
        if(check(sub2) && isValid(nums,idx+3)){
            return dp[idx]=true;
        }
        
        return dp[idx]=false;
    }
    
    boolean check(List<Integer> nums){
        int n = nums.size();
        int[] num = new int[n];
        
        for(int k = 0; k<n; k++){
            num[k] = nums.get(k);
        }
        
        if(n==2 && num[0]==num[1]) {
            return true;
        } 
        else if(n==3){ 
            if(num[0]==num[1] && num[1]==num[2]){
                return true;
            } 
            else if(num[1]==num[0]+1 && num[2]==num[1]+1){
                return true;
            }
        } else{
            return false;
        }
        return false;
    }
}