class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder st = new StringBuilder();
        
        while(columnNumber-- > 0){
            int rem = columnNumber % 26;
            st.append((char)(rem+'A'));
            columnNumber /= 26;
        }
        
        return st.reverse().toString();
    }
}