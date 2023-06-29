class Solution {
    Map<String,Integer> map;
    int[] rods;
    public int tallestBillboard(int[] rods) {
        this.rods=rods;
        map = new HashMap<>();
        int res = dfs(0,0);
        if(res>0){
            return res;
        } else return 0;
    }
    
    int dfs(int index,int total){
        if(index==rods.length){
            if(total==0){
                return 0;
            }
            return -50000001;
        }
        
        String state = index+","+total;
        
        if(map.containsKey(state)){
            return map.get(state);
        }
        
        int add = dfs(index+1,total+rods[index]) + rods[index];
        int sub = dfs(index+1,total-rods[index]);
        int idc = dfs(index+1,total);
        
        int max = Math.max(add,Math.max(sub,idc));
        
        map.put(state,max);
        
        return max;
    }
}