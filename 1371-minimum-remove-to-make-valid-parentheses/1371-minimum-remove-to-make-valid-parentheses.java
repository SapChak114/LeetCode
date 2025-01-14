class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        
        int p = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                p++;
                sb.append(c);
            } else if (c == ')' && p > 0) {
                p--;
                sb.append(c);
            } else if (c != ')') {
                sb.append(c);
            }
            
        }
    
        StringBuilder res = new StringBuilder();
        for (char c : sb.reverse().toString().toCharArray()) {
            if (c == '(' && p > 0) {
                p--;
            } else {
                res.append(c);
            }
        }

        return res.reverse().toString();
    }
}