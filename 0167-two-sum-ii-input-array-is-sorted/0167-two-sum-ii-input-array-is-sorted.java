class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i<numbers.length; i++){
            map.put(numbers[i],i);
        }
        
        for(int i = 0; i<numbers.length; i++){
            if(map.containsKey(target-numbers[i])){
                int x = map.get(target-numbers[i])+1;
                int y = i+1;
                return new int[]{Math.min(x,y),Math.max(x,y)};
            }
        }
        
        return new int[]{};
    }
}