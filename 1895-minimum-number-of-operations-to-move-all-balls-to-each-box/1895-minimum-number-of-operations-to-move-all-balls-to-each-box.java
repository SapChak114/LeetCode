class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length(), B = 0, X = 0, Y = 0, C = 0;
        int[] res = new int[n];

        for (int i = 0; i<n; i++) {
            res[i] += X;
            B += boxes.charAt(i)-'0';
            X += B;

            int j = n - i - 1;
            res[j] += Y;
            C += boxes.charAt(j)-'0';
            Y += C;
        }

        return res;
    }
}