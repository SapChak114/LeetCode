class Solution {
    public int minOperations(String s) {
        int count0 = 0, count1 = 0, n = s.length();
        
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            
            if(i%2==0){
                if(c=='0'){
                    count1++;
                } else{
                    count0++;
                }
            } else{
                if(c=='1'){
                    count1++;
                } else{
                    count0++;
                }
            }
        }
        
        return Math.min(count0,count1);
    }
}