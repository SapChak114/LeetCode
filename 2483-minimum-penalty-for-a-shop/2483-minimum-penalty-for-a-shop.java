class Solution {
    public int bestClosingTime(String cust) {
        int ans = 0, score = 0, n = cust.length();
        
        for(int i = 0; i<n; i++){
            if(cust.charAt(i)=='Y'){
                score++;
                
                if(score>0){
                    ans = i+1;
                    score=0;
                }
            } else{
                score--;
            }
        }
        
        return ans;
    }
}
