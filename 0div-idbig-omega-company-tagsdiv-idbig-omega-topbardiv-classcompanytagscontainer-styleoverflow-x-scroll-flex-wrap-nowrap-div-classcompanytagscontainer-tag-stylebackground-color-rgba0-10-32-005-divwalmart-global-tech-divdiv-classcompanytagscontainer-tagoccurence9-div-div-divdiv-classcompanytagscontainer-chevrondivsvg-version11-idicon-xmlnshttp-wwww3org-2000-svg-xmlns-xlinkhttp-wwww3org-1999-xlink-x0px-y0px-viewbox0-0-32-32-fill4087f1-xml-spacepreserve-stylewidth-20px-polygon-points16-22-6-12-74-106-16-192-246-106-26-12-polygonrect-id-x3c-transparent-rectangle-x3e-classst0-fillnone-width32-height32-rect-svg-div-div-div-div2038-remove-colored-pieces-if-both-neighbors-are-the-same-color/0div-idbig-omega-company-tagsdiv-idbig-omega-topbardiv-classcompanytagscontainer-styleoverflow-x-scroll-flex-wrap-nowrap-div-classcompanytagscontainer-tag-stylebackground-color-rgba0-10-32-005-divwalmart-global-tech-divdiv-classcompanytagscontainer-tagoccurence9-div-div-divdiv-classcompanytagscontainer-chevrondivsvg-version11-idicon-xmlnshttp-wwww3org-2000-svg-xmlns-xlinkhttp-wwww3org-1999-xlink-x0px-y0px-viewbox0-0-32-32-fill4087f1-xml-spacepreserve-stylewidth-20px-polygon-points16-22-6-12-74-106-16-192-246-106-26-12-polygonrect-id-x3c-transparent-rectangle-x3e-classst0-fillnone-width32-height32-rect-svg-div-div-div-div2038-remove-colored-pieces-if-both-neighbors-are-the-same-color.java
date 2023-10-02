class Solution {
    public boolean winnerOfGame(String c) {
        int n = c.length();
        int al = 0, bob = 0;
        
        for(int i = 0; i<n; i++){
            char ch = c.charAt(i);
            
            if(i!=0 && i!=n-1 && ch=='A' && c.charAt(i-1)=='A' && c.charAt(i+1)=='A'){
                al++;
            }
            
            else if(i!=0 && i!=n-1 && ch=='B' && c.charAt(i-1)=='B' && c.charAt(i+1)=='B'){
                bob++;
            }
        }
        return al>bob;
    }
}