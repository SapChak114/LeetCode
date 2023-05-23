class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        boolean[] incomming = new boolean[n];
        for(int i = 0; i<edges.size(); i++){
            incomming[edges.get(i).get(1)] = true;
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i<n; i++){
            if(!incomming[i]){
                res.add(i);
            }
        }
        
        return res;
    }
}