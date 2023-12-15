class Solution {
    public String destCity(List<List<String>> paths) {
        int n = paths.size();
        
        for(int i = 0; i<n; i++){
            String curr = paths.get(i).get(1);
            boolean val = true;
            
            for(int j = 0; j<n; j++){
                if(paths.get(j).get(0).equals(curr)){
                    val = false;
                }
            }
            
            if(val) return curr;
        }
        
        return "";
    }
}