class Solution {
    public boolean buddyStrings(String s, String g) {
        if(s.length()!=g.length()) return false;
        
        if(s.equals(g)){
            char[] ch = new char[26];
            
            for(int i = 0; i<s.length(); i++){
                ch[s.charAt(i) - 'a']++;
                if(ch[s.charAt(i) -'a']==2) return true;
            }
            return false;
        }
        
        int firstChar=-1, secondChar=-1;
        
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)!=g.charAt(i)){
                if(firstChar==-1){
                    firstChar=i;
                }
                else if(secondChar==-1){
                    secondChar=i;
                }
                
                else if(secondChar!=-1 && firstChar!=-1) return false;
            }
        }
        
        if(secondChar==-1) return false;
        
        return s.charAt(firstChar)==g.charAt(secondChar) && g.charAt(firstChar)==s.charAt(secondChar);
    }
}