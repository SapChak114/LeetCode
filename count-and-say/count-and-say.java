class Solution {
    public String countAndSay(int n) {
        int t =1;
        String curr = "1";
        
        while(t<n){
            int idx = 0;
            String ans = "";
            while(idx < curr.length()){
                char current = curr.charAt(idx);
                int freq = 0;
                while(idx<curr.length() && curr.charAt(idx)==current){
                    idx++;
                    freq++;
                }
                ans += String.valueOf(freq);
                ans += current;
            }
            curr = ans;
            t++;
        }
        
        return curr;
    }
}