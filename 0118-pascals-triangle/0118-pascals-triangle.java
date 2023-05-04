class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> sol = new ArrayList<>();
        
        for(int i= 0; i<numRows; i++){
            if(sol.size()==0){
                List<Integer> a = new ArrayList<>();
                a.add(1);
                sol.add(a);
            } else{
                List<Integer> al = sol.get(sol.size()-1);
                List<Integer> a = new ArrayList<>();
                a.add(1);
                if(al.size()>=2){
                    int x = 0;
                    while(x<al.size()-1){
                        int a1 = al.get(x);
                        int a2 = al.get(x+1);
                        a.add(a1+a2);
                        x++;
                    }
                }
                a.add(1);
                sol.add(a);
            }
        }
        
        return sol;
    }
}