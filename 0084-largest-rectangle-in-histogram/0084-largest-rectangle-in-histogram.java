class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] leftMax = leftSmallest(heights);
        int[] rightMax = rightSmallest(heights);
        
        int ans = 0;
        
        for(int i = 0 ; i<heights.length; i++){
            int left = leftMax[i];
            int right = rightMax[i];
            
            ans = Math.max(ans,heights[i]*(right-left-1));
        }
        
        return ans;
    }
    
    int[] leftSmallest(int[] A){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[A.length];
        
        for(int i=0; i<A.length; i++){
            while(!stack.isEmpty() && A[stack.peek()]>=A[i]) stack.pop();
            if(stack.isEmpty()) ans[i]=-1;
            else ans[i]=stack.peek();
            stack.push(i);
        }
        
        return ans;
    }
    
    int[] rightSmallest(int[] A){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[A.length];
        
        for(int i=A.length-1; i>=0; i--){
            while(!stack.isEmpty() && A[stack.peek()]>=A[i]) stack.pop();
            if(stack.isEmpty()) ans[i]=A.length;
            else ans[i]=stack.peek();
            stack.push(i);
        }
        
        return ans;
    }
}