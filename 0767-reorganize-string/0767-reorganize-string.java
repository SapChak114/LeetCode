class Solution {
    public String reorganizeString(String s) {
        StringBuilder st = new StringBuilder(s);
        String out = check(st);
        if(out.isEmpty()){
            return check(st.reverse());
        } else{
            return out;
        }
        
    }
    
    String check(StringBuilder st){
        
        for(int i = 1; i<st.length(); i++){
            char prev = st.charAt(i-1);
            char now =st.charAt(i);
            if(prev==now){
                int j = 0;
                for(j = i+1; j<st.length(); j++){
                    if(st.charAt(j)!=now){
                        char jth = st.charAt(j);
                        st.setCharAt(j,now);
                        st.setCharAt(i,jth);
                        break;
                    }
                }
                if(j==st.length()){
                    return "";
                }
            }
        }
        
        return st.toString();
    }
}