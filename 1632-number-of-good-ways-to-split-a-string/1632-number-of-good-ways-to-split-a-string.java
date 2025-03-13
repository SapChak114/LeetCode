class Solution {
    public int numSplits(String s) {
        int n = s.length();
        int count = 0;

        int[] left = new int[26];
        int[] right = new int[26];
        int rightDist = 0, leftDist = 0;

        for (char c : s.toCharArray()) {
            if (right[c-'a'] == 0) {
                rightDist++;
            }
            right[c-'a']++;
        }

        for (int i = 0; i<n; i++) {
            char c = s.charAt(i);

            if (left[c-'a'] == 0) {
                leftDist++;
            }
            left[c-'a']++;

            right[c-'a']--;
            if (right[c-'a'] == 0) {
                rightDist--;
            }

            if (leftDist == rightDist) {
                count++;
            }
        }

        return count;
    }
}