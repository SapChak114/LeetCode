class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> li = new ArrayList<>();
        
        for(int x : nums){
            int idx = bs(li,x);
            if(idx==li.size()){
                li.add(x);
            }
            li.set(idx,x);
        }
        
        return li.size();
        
    }
    
    int bs(List<Integer> list, int targ){
        int l = 0, r = list.size();
        
        while(l<r){
            int mid = l + (r-l)/2;
            if(list.get(mid)==targ){
                return mid;
            }
            else if(list.get(mid)<targ){
                l = mid + 1;
            } else{
                r = mid;
            }
        }
        
        return l;
    }
}