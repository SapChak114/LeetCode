class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        check(n,"",0,0);
        return res;
    }
    
    void check(int n, String s, int open, int close){
        
        if(s.length()==n*2){
            res.add(s);
            return;
        }
        
        if(open<n){
            check(n,s+'(',open+1,close);
        }
        if(close<open){
            check(n,s+')',open,close+1);
        }
    }
}