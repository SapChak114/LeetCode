class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        back(res,n,k,1,list);
        return res;
    }
    
    void back(List<List<Integer>> res, int n, int k, int start, List<Integer> li){
        if(li.size()==k){
            List<Integer> list = new ArrayList<>(li);
            res.add(list);
            return;
        }
        
        
        for(int i = start; i<=n; i++){
            li.add(i);
            back(res,n,k,i+1,li);
            li.remove(li.size()-1);
        }
    }
}