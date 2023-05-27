class Solution {
    int[] values;
    HashMap<String,Integer> map;
    
    static int inf = 100000000;
    
    int f(int p, int i){
        if(i>=values.length){
            return 0;
        }
        
        String key = p + "," + i;
        if(map.containsKey(key)) return map.get(key);
        
        int res = p==1?inf:-inf, sum = 0;
        
        for(int take = 1; take<4; take++){
            if(i + take > values.length) break;
            sum += values[i + take - 1];
            if(p==0){
                res = Math.max(res,sum + f(1,i + take));
            } else{
                res = Math.min(res,f(0,i + take));
            }
        }
        map.put(key,res);
        
        return res;
        
    }
    
    
    public String stoneGameIII(int[] stoneValue) {
        values = stoneValue;
        map = new HashMap<>();
        
        int alice = f(0,0);
        
        int bob = 0;
        
        for(int st : stoneValue) bob += st;
        
        bob -= alice;
        
        if(alice > bob){
            return "Alice";
        }
        else if(bob > alice){
            return "Bob";
        } else{
            return "Tie";
        }
    }
}