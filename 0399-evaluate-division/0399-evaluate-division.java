class Solution {
    public double[] calcEquation(List<List<String>> eq, double[] values, List<List<String>> q) {
        Map<String,Map<String,Double>> adjMap = new HashMap<>();
        
        for(int i = 0; i<eq.size(); i++){
            String u = eq.get(i).get(0);
            String v = eq.get(i).get(1);
            if(!adjMap.containsKey(u)) adjMap.put(u,new HashMap<>());
            if(!adjMap.containsKey(v)) adjMap.put(v,new HashMap<>());
            
            double w = values[i];
            
            adjMap.get(u).put(v,w);
            adjMap.get(v).put(u,(1.0/w));
        }
        
        double result[] = new double[q.size()];
        
        for(int i = 0; i<q.size(); i++){
            String u = q.get(i).get(0);
            String v = q.get(i).get(1);
            
            if(!adjMap.containsKey(u)){
                result[i] = -1;
            } else{
                result[i] = dfs(adjMap,u,v,new HashSet<>(),1);
            }
        }
        
        System.out.println(adjMap);
        return result;
    }
    
    double dfs(Map<String,Map<String,Double>> adjMap, String u, String v, Set<String> vis,double value){
        if(u.equals(v)){
            return value;
        }
        
        vis.add(u);
        double result = -1.0;
        
        Map<String,Double> graph = adjMap.get(u);
        
        for(String key : graph.keySet()){
            if(!vis.contains(key)){
                double newRes = value * graph.get(key);
                result = dfs(adjMap,key,v,vis,newRes);
                if(result != -1){
                    break;
                }
            }
        }
        
        return result;
        
    }
}