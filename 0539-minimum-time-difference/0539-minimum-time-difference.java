class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] minutes = new int[n];
        
        // Convert each time point to minutes
        for (int i = 0; i < n; i++) {
            String time = timePoints.get(i);
            int hour = Integer.parseInt(time.substring(0, 2));
            int minute = Integer.parseInt(time.substring(3, 5));
            minutes[i] = hour * 60 + minute;
        }
        
        // Sort the time points by the minute representation
        Arrays.sort(minutes);
        
        // Initialize the minimum difference to the max possible value
        int minDiff = Integer.MAX_VALUE;
        
        // Calculate the difference between consecutive times
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, minutes[i] - minutes[i - 1]);
        }
        
        // Check the circular difference between the last and first time points
        int circularDiff = (1440 - minutes[n - 1]) + minutes[0];
        minDiff = Math.min(minDiff, circularDiff);
        
        return minDiff;
    }
}