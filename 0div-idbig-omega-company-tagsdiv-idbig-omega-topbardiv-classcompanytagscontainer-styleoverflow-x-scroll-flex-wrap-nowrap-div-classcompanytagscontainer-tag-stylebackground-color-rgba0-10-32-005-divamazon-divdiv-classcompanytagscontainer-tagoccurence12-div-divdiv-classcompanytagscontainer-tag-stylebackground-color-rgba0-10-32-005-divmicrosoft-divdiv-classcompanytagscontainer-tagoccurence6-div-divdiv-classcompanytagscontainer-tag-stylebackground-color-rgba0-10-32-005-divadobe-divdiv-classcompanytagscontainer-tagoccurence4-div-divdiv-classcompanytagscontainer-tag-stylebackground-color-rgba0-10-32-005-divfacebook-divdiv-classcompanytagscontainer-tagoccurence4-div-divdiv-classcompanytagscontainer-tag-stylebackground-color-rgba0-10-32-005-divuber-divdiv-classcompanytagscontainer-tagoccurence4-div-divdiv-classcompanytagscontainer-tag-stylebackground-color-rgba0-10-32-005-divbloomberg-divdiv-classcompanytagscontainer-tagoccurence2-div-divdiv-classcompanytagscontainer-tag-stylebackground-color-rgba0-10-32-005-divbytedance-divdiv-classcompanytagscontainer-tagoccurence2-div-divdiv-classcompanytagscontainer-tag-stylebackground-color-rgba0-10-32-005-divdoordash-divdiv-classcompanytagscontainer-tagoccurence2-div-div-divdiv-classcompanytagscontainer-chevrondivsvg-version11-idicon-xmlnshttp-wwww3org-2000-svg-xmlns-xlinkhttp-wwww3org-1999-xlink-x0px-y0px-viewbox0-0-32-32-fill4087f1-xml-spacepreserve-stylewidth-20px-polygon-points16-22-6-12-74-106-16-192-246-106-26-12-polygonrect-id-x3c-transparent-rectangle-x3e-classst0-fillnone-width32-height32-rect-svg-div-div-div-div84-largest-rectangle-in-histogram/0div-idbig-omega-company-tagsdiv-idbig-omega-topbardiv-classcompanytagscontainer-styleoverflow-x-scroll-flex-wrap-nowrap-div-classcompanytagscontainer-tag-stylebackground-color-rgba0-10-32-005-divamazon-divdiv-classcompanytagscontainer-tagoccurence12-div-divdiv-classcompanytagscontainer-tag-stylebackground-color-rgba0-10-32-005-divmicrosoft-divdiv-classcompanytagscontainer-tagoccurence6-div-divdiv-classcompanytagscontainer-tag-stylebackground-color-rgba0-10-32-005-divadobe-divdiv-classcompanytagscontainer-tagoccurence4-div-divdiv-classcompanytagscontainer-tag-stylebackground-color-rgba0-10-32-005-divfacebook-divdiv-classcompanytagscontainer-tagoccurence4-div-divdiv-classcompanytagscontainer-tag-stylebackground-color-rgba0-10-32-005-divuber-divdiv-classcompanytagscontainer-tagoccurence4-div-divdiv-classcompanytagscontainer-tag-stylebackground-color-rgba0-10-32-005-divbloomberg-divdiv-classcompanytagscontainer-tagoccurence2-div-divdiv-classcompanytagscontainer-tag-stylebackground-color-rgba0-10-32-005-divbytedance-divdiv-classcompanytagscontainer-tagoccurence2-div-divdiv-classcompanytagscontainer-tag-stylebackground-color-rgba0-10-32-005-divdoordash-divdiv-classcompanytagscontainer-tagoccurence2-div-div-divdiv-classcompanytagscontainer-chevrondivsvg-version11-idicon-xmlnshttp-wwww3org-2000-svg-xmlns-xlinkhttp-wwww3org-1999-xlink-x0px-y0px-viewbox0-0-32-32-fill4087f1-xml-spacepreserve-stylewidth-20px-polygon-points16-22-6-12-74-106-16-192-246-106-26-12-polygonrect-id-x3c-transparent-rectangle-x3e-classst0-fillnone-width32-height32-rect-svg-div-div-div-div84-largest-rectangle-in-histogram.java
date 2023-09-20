class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] leftSmall = leftSmallerArea(heights);
        int[] rightSmall = rightSmallArea(heights);
        
        int n = heights.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            int val = rightSmall[i] - leftSmall[i] - 1;
            max = Math.max(max,val*heights[i]);
        }
        
        return max;
    }
    
    int[] leftSmallerArea(int[] heights){
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        
        int[] ans = new int[n];
        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]) st.pop();
            if(st.isEmpty()) ans[i]=-1;
            else ans[i]= st.peek();
            st.push(i);
        }
        return ans;
    }
    
    int[] rightSmallArea(int[] heights){
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        
        int[] ans = new int[n];
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]) st.pop();
            if(st.isEmpty()) ans[i]=heights.length;
            else ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }
}