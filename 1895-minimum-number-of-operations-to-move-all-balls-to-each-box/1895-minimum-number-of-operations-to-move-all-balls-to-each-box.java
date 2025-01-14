class Solution {
    public int[] minOperations(String s) {
        int n = s.length();
        int[] res = new int[n];

        for (int i = 0; i<n; i++) {
            int count = 0;
            for (int j = 0; j<n; j++) {
                if (s.charAt(j) == '0') {
                    continue;
                }
                count += Math.abs(j-i);
            }
            res[i] = count;
        }

        return res;
    }
}