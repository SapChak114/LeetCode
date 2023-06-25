class Solution {
    int[] coins;
    Map<String,Integer> map;
    public int change(int amount, int[] coins) {
        this.map = new HashMap<>();
        this.coins=coins;
        return dfs(0,amount);
    }
    
    int dfs(int idx,int amount){
        if(amount<0){
            return 0;
        }
        
        if(idx==coins.length){
            if(amount==0){
                return 1;
            } else{
                return 0;
            }
        }
        String key = idx+","+amount;
        
        if(map.containsKey(key)) return map.get(key);
        
        int take = dfs(idx,amount-coins[idx]);
        int dont = dfs(idx+1,amount);
        
        map.put(key,(take+dont));
        
        return take+dont;
    }
}