class Solution {
    Map<String,Integer> map;
    public boolean PredictTheWinner(int[] nums) {
        map = new HashMap<>();
        int player1 = rec(nums,0,nums.length-1,1);
        int sum = 0;
        for(int s : nums){
            sum += s;
        }
        
        int player2 = sum - player1;
        
        return player1>=player2;
    }
    
    
    public int rec(int[] nums, int left, int right,int player){
        if(left>right){
            return 0;
        }
        
        String key = left+"-"+right+"-"+player;
        
        if(map.containsKey(key)) return map.get(key);
        
        if(player==1){
            int first = nums[left] + rec(nums,left+1,right,2);
            int second = nums[right] + rec(nums,left,right-1,2);
            
            map.put(key,Math.max(first,second));
            
            return Math.max(first,second);
        } else{
            
            int first = rec(nums,left+1,right,1);
            int second = rec(nums,left,right-1,1);
            
            map.put(key,Math.min(first,second));
            
            return Math.min(first,second);
        }
        
    }
    
    
}