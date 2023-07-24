class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        
        for(String s : tokens){
            if(isOp(s)){
                int num1 = st.pop();
                int num2 = st.pop();
                int num3 = calc(num2,num1,s);
                st.add(num3);
            } else{
                st.add(Integer.valueOf(s));
            }
        }
        
        return st.pop();
    }
    
    boolean isOp(String x){
        return x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/");
    }
    
    int calc(int num1, int num2, String x){
        if(x.equals("+")) return num1 + num2;
        else if(x.equals("-")) return num1 - num2;
        else if(x.equals("*")) return num1 * num2;
        else if(x.equals("/")) return num1/num2;
        return 0;
    }
}