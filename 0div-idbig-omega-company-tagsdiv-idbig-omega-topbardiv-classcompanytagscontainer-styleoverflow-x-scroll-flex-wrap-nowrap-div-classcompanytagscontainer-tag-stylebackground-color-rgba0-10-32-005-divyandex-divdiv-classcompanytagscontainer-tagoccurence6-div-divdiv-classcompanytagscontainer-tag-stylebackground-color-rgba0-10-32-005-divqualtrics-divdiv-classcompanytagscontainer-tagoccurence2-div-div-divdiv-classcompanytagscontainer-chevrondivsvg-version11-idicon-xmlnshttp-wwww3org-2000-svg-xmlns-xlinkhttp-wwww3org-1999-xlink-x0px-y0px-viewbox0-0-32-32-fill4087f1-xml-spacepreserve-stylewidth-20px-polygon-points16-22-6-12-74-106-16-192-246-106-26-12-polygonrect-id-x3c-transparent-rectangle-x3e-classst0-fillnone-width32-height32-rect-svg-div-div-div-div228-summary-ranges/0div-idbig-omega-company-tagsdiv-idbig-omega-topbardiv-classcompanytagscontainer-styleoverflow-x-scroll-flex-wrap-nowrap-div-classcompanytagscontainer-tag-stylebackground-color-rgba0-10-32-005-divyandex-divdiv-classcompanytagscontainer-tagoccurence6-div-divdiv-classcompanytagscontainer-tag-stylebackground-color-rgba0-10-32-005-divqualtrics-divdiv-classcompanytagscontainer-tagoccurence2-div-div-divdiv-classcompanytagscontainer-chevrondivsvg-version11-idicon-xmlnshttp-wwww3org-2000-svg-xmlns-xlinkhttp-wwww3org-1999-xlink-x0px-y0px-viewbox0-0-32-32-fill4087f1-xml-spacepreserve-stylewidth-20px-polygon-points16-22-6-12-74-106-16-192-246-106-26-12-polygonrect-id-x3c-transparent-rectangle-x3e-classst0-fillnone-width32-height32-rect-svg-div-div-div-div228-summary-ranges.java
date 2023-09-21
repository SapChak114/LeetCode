class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> li = new ArrayList<>();
        int n = nums.length;
        
        for(int i = 0; i<n; i++){
            int start = nums[i];
            while(i!=n-1 && nums[i]+1==nums[i+1]){
                i++;
            }
            
            if(start!=nums[i]){
                li.add(start+"->"+nums[i]);
            } else{
                li.add(""+nums[i]);
            }
        }
        
        return li;
    }
}