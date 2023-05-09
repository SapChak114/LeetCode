class Solution {
    public List<Integer> spiralOrder(int[][] m) {
        List<Integer> al = new ArrayList<Integer>();
        int A = m.length;
        int B = m[0].length;
        int top = 0, left = 0, bottom = A-1, right=B-1;
        while(top<=bottom && right>=left){
            
            for(int i = left; i<=right; i++){
                al.add(m[top][i]);
            }
            top++;
            for(int i=top; i<=bottom; i++){
                al.add(m[i][right]);
            }
            right--;

            if(!(top<=bottom && right>=left)){
                break;
            }
            
            for(int i = right; i>=left; i--){
                 al.add(m[bottom][i]);
            }
            bottom--;
            for(int i = bottom; i>=top; i--){
                 al.add(m[i][left]);
            }
            left++;
        }

        return al;
    }
}