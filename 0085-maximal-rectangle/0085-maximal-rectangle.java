class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] mat = new int[m];
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(matrix[i][j]=='1'){
                    mat[j] += 1;
                } else{
                    mat[j] = 0;
                }
            }
            max = Math.max(max,lra(mat));
        }
        
        return max;
    }
    
     private int lra(int[] A) {
        int[] leftSmall = leftSmall(A);
        int[] rightSmall = rightSmall(A);

        int max = Integer.MIN_VALUE;
        for(int i = 0; i<A.length; i++){
            int val = rightSmall[i] - leftSmall[i] - 1;
            max = Math.max(max,A[i]*val);
        }

        return max;
    }

    int[] leftSmall(int[] A){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[A.length];
        for(int i = 0; i<A.length; i++){
            while(!st.isEmpty() && A[st.peek()]>=A[i]) st.pop();
            if(st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();
            st.add(i);
        }
        return ans;
    }

    int[] rightSmall(int[] A){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[A.length];
        for(int i = A.length-1; i>=0; i--){
            while(!st.isEmpty() && A[st.peek()]>=A[i]) st.pop();
            if(st.isEmpty()) ans[i] = A.length;
            else ans[i] = st.peek();
            st.add(i);
        }
        return ans;
    }
}