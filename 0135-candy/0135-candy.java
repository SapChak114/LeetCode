class Solution {
    public int candy(int[] ratings) {
        int i = 1;
        int n = ratings.length;
        int total = n;
            
        while(i<n){
            if(ratings[i-1]==ratings[i]){
                i++;
                continue;
            }
        
            int peek = 0;
            while(ratings[i-1]<ratings[i]){
                peek++;
                total += peek;
                i++;
                if(i == n) return total;
            }

            int slope = 0;
            while(i<n && ratings[i-1]>ratings[i]){
                slope++;
                total += slope;
                i++;
            }
            total -= Math.min(peek,slope);
        }
        
        return total;
    }
}