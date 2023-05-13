class Solution {
    int mod = (int)1e9 + 7;
    Map<Integer,Integer> map;
    public int countGoodStrings(int low, int high, int zero, int one) {
        map = new HashMap<>();
        int count = 0;
        for(int i = low; i<=high; i++){
            count +=dfs(i,one,zero);
            count %= mod;
        }
        return count;
    }
    
    int dfs(int total, int one, int zero){
        if(total==0){
            return 1;
        }
        if(total<0){
            return 0;
        }
        if(map.containsKey(total)) return map.get(total);
        
        int way1 = dfs(total-one,one,zero)%mod;
        int way2 = dfs(total-zero,one,zero)%mod;
        int way = (way1 + way2)%mod;
        map.put(total,way);
        return way;
    }
}