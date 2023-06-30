class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int majority = n/2;
        majority++;
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            } else{
                map.put(num,1);
            }
        }
        
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getValue()>=majority){
                return e.getKey();
            }
        }
        
        return -1;
        
    }
}