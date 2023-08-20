class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        TreeMap<Integer,Integer> freq = new TreeMap<>(Collections.reverseOrder());
        
        int n = nums.size(), l = 0, ans = 0;
        
        for(int r = 0; r<n; r++){
            map.put(nums.get(r),map.getOrDefault(nums.get(r),0)+1);
            freq.put(map.get(nums.get(r)),freq.getOrDefault(map.get(nums.get(r)),0)+1);
            
            // if(map.get(nums.get(r))>1){
            //     freq.put(map.get(nums.get(r))-1,freq.getOrDefault(map.get(nums.get(r))-1,0)-1);
            // }
            
            int rem = r-l+1 - freq.firstKey();
            
            while(rem>k){
                map.put(nums.get(l),map.get(nums.get(l))-1);
                freq.put(map.get(nums.get(l)),freq.getOrDefault(map.get(nums.get(l)),0)+1);
                // freq.put(map.get(nums.get(l))-1,freq.getOrDefault(map.get(nums.get(l))-1,0)-1);
                // if(freq.get(map.get(nums.get(l))-1)==0){
                //     freq.remove(map.get(nums.get(l))-1);
                // }
                
                l++;
                
                rem = r-l+1 - freq.firstKey();
            }
            
            ans = Math.max(ans,freq.firstKey());
            
        }
        
        return ans;
    }
}