class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        List<Integer> result = new ArrayList<>();
        
        // Edge case: if time is 0, all days are good
        if (time == 0) {
            for (int i = 0; i < n; i++) {
                result.add(i);
            }
            return result;
        }
        
        // Arrays to store consecutive non-increasing/non-decreasing days
        int[] nonIncreasing = new int[n];  // nonIncreasing[i] = consecutive non-increasing days before i
        int[] nonDecreasing = new int[n];  // nonDecreasing[i] = consecutive non-decreasing days after i
        
        // Fill nonIncreasing array (left to right)
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                nonIncreasing[i] = nonIncreasing[i - 1] + 1;
            }
        }
        
        // Fill nonDecreasing array (right to left)
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                nonDecreasing[i] = nonDecreasing[i + 1] + 1;
            }
        }
        
        // Find good days
        for (int i = time; i < n - time; i++) {
            if (nonIncreasing[i] >= time && nonDecreasing[i] >= time) {
                result.add(i);
            }
        }
        
        return result;
    }
}