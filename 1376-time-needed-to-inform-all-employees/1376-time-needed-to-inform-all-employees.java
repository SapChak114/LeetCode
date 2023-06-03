class Solution {
    int maxTime;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        maxTime=0;
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i<n; i++){
            if(manager[i]==-1){
                continue;
            }
            
            if(!map.containsKey(manager[i])){
                List<Integer> li = new ArrayList<>();
                li.add(i);
                map.put(manager[i],li);
            } else{
                List<Integer> li = map.get(manager[i]);
                li.add(i);
            }
        }
        
        dfs(map,manager,headID,informTime,0);
        return maxTime;
    }
    
    void dfs(Map<Integer,List<Integer>> map, int[] manager, int headID, int[] informTime, int t){
        
        if(informTime[headID]==0){
            return;
        }
        
        t += informTime[headID];
        
        List<Integer> li = map.get(headID);
        
        for(int i = 0; i<li.size(); i++){
            dfs(map,manager,li.get(i),informTime,t);
            if(maxTime<t){
                maxTime=t;
            }
        }
        
    }
}