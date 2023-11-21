class Solution {
    public int countNicePairs(int[] nums) {
        int n = nums.length;
        int M = (int)1e9 + 7;
        int res = 0;
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = n-1; i>=0; i--){
            int diff = nums[i] - rev(nums[i]);
            if(map.containsKey(diff)){
                res = (res + map.get(diff))%M;
            }
            map.put(diff,map.getOrDefault(diff,0)+1);
        }
        
        return res;
    }
    
    public int rev(int num) {
        int result = 0;
        while (num > 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }
        
        return result;
    }
}