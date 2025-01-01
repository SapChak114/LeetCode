class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int right = 0;

        for (int i = 0; i<n; i++) {
            if (s.charAt(i) == '1') {
                right++;
            }
        }

        int left = 0, ans = 0;
        for (int i = 0 ;i<n-1; i++) {
            if (s.charAt(i) == '1') {
                left++;
            }
            
            int sum = ((i+1) - left) +  (right - left);
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}