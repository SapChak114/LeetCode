class Solution {
    int prime = (int)1e9+7;
    public int longestArithSeqLength(int[] nums) {
        Map<Long,Integer> map = new HashMap<>();
        int n = nums.length;
        
        for(int right = 0; right<n; right++){
            for(int left=0; left<right; left++){
                int d = nums[right]-nums[left];
                long numRight = (long)right*prime + (long)d;
                long numLeft = (long)left*prime + (long)d;
                map.put(numRight,map.getOrDefault(numLeft,1)+1);
            }
        }
        
        return Collections.max(map.values());
    }
}