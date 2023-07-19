class Solution {
    public int eraseOverlapIntervals(int[][] in) {
        Arrays.sort(in,(int[] in1,int[] in2)->Integer.compare(in1[1],in2[1]));
        
        int count = 0, prev = Integer.MIN_VALUE, n = in.length;
        
        for(int[] i : in){
            int x = i[0];
            int y = i[1];
            
            if(prev<=x){
                prev = y;
            } else {
                count++;
            }
        }
        
        return count;
    }
}