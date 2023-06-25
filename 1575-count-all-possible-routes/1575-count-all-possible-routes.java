class Solution {
    Map<String,Integer> map;
    int mod = (int)1e9 + 7;
    int finish;
    int[] locs;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        this.map = new HashMap<>();
        this.locs = locations;
        this.finish=finish;
        return dfs(start,fuel);
    }
    
    int dfs(int idx, int fuel){
        if(fuel<0){
            return 0;
        }
        
        String key = idx +","+fuel;
        if(map.containsKey(key)) return map.get(key);
        
        int ways = idx==finish?1:0;
        
        for(int i = 0; i<locs.length; i++){
            if(i==idx) continue;
            int need = Math.abs(locs[i]-locs[idx]);
            ways += dfs(i,fuel-need);
            ways %= mod;
        }
        
        map.put(key,ways);
        return ways;
    }
}