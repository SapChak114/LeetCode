class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length, elem = 0, cnt = 0;
        
        for(int i = 0; i<n; i++){
            if(cnt==0){
                cnt = 1;
                elem = nums[i];
            }
            else if(elem==nums[i]){
                cnt++;
            } else{
                cnt--;
            }
        }
        
        cnt = 0;
        for(int i = 0; i<n; i++){
            if(elem==nums[i]){
                cnt++;
            }
        }
        
        if(cnt>n/2) return elem;
        else return -1;
    }
}