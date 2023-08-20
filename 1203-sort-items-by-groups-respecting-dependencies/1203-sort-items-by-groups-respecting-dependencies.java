class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        Map<Integer,Integer> groupMap = new HashMap<>();
        
        int count = m;
        for(int i = 0; i<group.length; i++){
            int item = group[i];
            if(item==-1){
                item = count++;
            }
            groupMap.put(i,item);
            if(!map.containsKey(item)){
                Set<Integer> set = new HashSet<>();
                set.add(i);
                map.put(item,set);
            } else{
                Set<Integer> set = map.get(item);
                set.add(i);
            }
        }
        
        Map<Integer,List<Integer>> topo = new HashMap<>();
        Map<Integer,List<Integer>> adjGroups = new HashMap<>();
        
        for(int i = 0; i<count; i++){
            adjGroups.put(i,new ArrayList<>());
            topo.put(i,new ArrayList<>());
        }
        
        for(Map.Entry<Integer,Set<Integer>> e : map.entrySet()){
            
            Map<Integer,List<Integer>> adjList = getadjList(e.getValue(),beforeItems,adjGroups,groupMap);
            
            if(checkCycle(adjList)){
                return new int[]{};    
            }
            
            Set<Integer> vis = new HashSet<>();
            
            List<Integer> topoList = new ArrayList<>();
            for(Map.Entry<Integer,List<Integer>> f : adjList.entrySet()){
                if(!vis.contains(f.getKey())){
                    dfs(f.getKey(),vis,adjList,topoList);
                }
            }
            topo.put(e.getKey(),topoList);
        }
        
        if(checkCycle(adjGroups)){
            return new int[]{};    
        }
         // System.out.println(topo);
         // System.out.println(adjGroups);
        
        List<Integer> topoGroups = new ArrayList<>();
        
        Set<Integer> visited = new HashSet<>();
        
         for(Map.Entry<Integer,List<Integer>> f : adjGroups.entrySet()){
            if(!visited.contains(f.getKey())){
                dfs(f.getKey(),visited,adjGroups,topoGroups);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        //System.out.println(topoGroups);
        
        for(int i = 0; i<topoGroups.size(); i++){
            //System.out.println(topoGroups.get(i)+"  "+i);
            List<Integer> li = topo.get(topoGroups.get(i));
            ans.addAll(li);
        }
        
        //System.out.println(ans);
        
        int[] res = new int[ans.size()];
        
        for(int i = 0; i<ans.size(); i++){
            res[i] = ans.get(i);
        }
        
        
        
        return res;
    }
    
    
    void dfs(int node, Set<Integer> vis, Map<Integer,List<Integer>> adjList, List<Integer> res){
        vis.add(node);
        
        for(int n : adjList.get(node)){
            if(!vis.contains(n)){
                dfs(n,vis,adjList,res);
            }
        }
        res.add(node);
    }
    
    
    
    Map<Integer,List<Integer>> getadjList(Set<Integer> set, List<List<Integer>> beforeItems, Map<Integer,List<Integer>> adjGroup, Map<Integer,Integer> groupMap){
        int n = set.size();
        List<Integer> li = new ArrayList<>(set);
        
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        
        for(int i = 0; i<n; i++){
            int elem = li.get(i);
            adjList.put(elem,new ArrayList<>());
        }
        
        for(int i = 0; i<n; i++){
            int u = li.get(i);
            List<Integer> v = beforeItems.get(u);
            for(int x : v){
                if(set.contains(x)){
                    adjList.get(u).add(x);
                } else{
                    // link within the groups now
                    int groupU = groupMap.get(u);
                    int groupX = groupMap.get(x);
                    adjGroup.get(groupU).add(groupX);
                }
            }
        }
        
        return adjList;
    }
    
    boolean checkCycle(Map<Integer,List<Integer>> adjList){
        Map<Integer,Integer> vis = new HashMap<>();
        
        for(Map.Entry<Integer,List<Integer>> e : adjList.entrySet()){
            if(vis.getOrDefault(e.getKey(),0)==0){
                if(dfsc(e.getKey(),vis,adjList)) return true;
            }
        }
        
        return false;
    }
    
    boolean dfsc(int node,  Map<Integer,Integer> vis, Map<Integer,List<Integer>> adjList){
        vis.put(node,1);
        
        for(int n : adjList.get(node)){
            if(vis.getOrDefault(n,0)==0){
                if(dfsc(n,vis,adjList)) return true;
            }
            else if(vis.containsKey(n) && vis.get(n)==1){
                return true;
            }
        }
        
        vis.put(node,2);
        
        return false;
    }
}