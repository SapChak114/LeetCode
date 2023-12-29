class Solution {
    String s;
    Map<String,Integer> map;
    int n;
    public int getLengthOfOptimalCompression(String s, int k) {
        this.s = s;
        this.n = s.length();
        map = new HashMap<>();
        return dfs(0,'#',0,k);
    }
    
    int dfs(int idx, char pChar, int streak, int delete){
        if(idx >= n){
            return cost(streak);
        }
        
        String key = idx+"-"+pChar+"-"+streak+"-"+delete;
        if(map.containsKey(key)) return map.get(key);
        
        char c = s.charAt(idx);
        
        int minCount = Integer.MAX_VALUE;
        
        //take
        if(c==pChar){
            minCount = Math.min(minCount,dfs(idx+1,c,streak+1,delete));
        } else{
            minCount = Math.min(minCount,cost(streak) + dfs(idx+1,c,1,delete));
        }
        
        //dont
        if(delete>=1){
            minCount = Math.min(minCount,dfs(idx+1,pChar,streak,delete-1));
        }
        
        map.put(key,minCount);
        
        return minCount;
    }
    
    int cost(int streak){
        if(streak==0) return 0;
        else if(streak==1) return 1;
        else if(streak<=9) return 2;
        else if(streak<=99) return 3;
        else return 4;
    }
        
}