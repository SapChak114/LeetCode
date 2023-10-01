class Solution {
    public String reverseWords(String s) {
        String[] st = s.split(" ");
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<st.length; i++){
            String ss = st[i];
            String sk = "";
            for(int j = ss.length()-1; j>=0; j--){
                sk += ss.charAt(j);
            }
            if(i!=st.length-1) sb.append(sk+" ");
            else sb.append(sk);
        }
        
        return sb.toString();
    }
}