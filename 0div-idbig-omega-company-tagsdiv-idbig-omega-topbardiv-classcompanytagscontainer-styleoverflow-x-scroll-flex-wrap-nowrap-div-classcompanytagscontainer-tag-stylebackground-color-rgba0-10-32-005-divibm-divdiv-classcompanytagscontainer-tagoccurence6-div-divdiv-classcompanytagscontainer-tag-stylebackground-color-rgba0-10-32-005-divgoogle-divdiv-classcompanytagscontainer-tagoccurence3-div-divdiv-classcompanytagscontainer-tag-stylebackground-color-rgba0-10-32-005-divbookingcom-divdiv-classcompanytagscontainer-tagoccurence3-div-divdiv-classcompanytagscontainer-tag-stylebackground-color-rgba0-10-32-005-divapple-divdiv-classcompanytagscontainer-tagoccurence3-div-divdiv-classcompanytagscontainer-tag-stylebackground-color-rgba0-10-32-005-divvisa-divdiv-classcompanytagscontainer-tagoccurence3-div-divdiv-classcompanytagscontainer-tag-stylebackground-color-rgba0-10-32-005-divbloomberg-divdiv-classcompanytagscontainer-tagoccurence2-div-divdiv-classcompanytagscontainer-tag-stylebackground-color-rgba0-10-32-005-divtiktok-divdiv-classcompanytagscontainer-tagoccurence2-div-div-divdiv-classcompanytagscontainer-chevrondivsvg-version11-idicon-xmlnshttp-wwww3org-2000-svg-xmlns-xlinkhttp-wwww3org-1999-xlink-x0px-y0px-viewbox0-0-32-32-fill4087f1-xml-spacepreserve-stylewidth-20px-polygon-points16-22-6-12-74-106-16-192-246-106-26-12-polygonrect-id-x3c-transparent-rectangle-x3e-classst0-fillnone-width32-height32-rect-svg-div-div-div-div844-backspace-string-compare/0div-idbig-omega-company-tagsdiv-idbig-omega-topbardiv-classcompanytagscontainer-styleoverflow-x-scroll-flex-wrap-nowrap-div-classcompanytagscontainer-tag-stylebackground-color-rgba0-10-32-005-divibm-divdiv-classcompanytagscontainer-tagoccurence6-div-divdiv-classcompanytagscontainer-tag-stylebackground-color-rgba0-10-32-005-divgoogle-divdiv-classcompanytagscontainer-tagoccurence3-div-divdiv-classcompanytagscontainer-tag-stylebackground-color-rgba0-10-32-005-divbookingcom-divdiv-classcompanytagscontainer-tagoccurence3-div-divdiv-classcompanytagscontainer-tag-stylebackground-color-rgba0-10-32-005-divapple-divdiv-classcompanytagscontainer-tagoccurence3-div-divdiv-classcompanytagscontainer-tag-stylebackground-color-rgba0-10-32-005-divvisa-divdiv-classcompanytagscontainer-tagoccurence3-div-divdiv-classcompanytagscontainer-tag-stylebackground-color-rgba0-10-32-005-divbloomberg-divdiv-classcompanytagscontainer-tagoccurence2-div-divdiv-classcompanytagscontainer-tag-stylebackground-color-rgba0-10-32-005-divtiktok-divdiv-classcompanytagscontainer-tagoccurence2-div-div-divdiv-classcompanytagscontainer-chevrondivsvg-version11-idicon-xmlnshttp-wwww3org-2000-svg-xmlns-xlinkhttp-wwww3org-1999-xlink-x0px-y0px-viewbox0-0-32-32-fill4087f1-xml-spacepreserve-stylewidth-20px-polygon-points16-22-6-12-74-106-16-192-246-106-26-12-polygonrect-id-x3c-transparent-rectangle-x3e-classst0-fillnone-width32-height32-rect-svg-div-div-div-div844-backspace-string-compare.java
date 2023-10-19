class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }
    
    private String build(String S){
        Stack<Character> st = new Stack<>();
        
        for(char c : S.toCharArray()){
            if(c!='#'){
                st.push(c);
            }
            else if(!st.isEmpty()){
                st.pop();
            }
        }
        
        return String.valueOf(st);
    }
}