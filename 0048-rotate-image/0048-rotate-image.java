class Solution {
    public void rotate(int[][] m) {
        int l = 0, r = m.length - 1;

        while (l < r) {
            for (int i = 0; i< (r - l); i++) {
                int top = l, bottom = r;

                // save top left
                int topLeft = m[top][l + i];

                // move bottom left into top left
                m[top][l + i] = m[bottom - i][l];

                // move bottom right into bottom left
                m[bottom - i][l] = m[bottom][r - i];

                // move top right into bottom right
                m[bottom][r - i] = m[top + i][r];

                // move top left into top right
                m[top + i][r] = topLeft;
            }

            r -= 1;
            l += 1;
        }
    }
}