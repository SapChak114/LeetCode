class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;

        long maxSide = 0;
        for (int i = 0; i<n; i++) {
            for (int j = i+1; j<n; j++) {
                long left = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                long right = Math.min(topRight[i][0], topRight[j][0]);
                long width = right - left;
                long top = Math.min(topRight[i][1], topRight[j][1]);
                long bottom = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                long length = top - bottom;
                long side = Math.min(width, length);
                maxSide = Math.max(maxSide, side);
            }
        }

        return maxSide * maxSide;
        
    }
}