class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        int n = nums.length;
        
        int threshold = nums.length/3;
        
        List<Integer> res = new ArrayList<>();
        
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            int val = e.getKey();
            int count = e.getValue();
            
            if(count>threshold){
                res.add(val);
            }
        }
        
        return res;
        
    }
}