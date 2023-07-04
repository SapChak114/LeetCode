class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        
        StringBuilder res = new StringBuilder();
        String st = "";
        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i)!=' '){
                st = s.charAt(i) + st;
            } else{
                if(res.isEmpty()) res.append(st);
                else{
                        if(st.trim()!="") res.append(" "+ st);
                }
                st = "";
            }
        }
        
        if(!st.isEmpty()) res.append(" "+ st);
        return res.toString().trim();
    }
}