class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int max = Math.abs(target[1]) + Math.abs(target[0]);
        int res = 0;

        for (int[] g : ghosts) {
            int d = Math.abs(g[0] - target[0]) + Math.abs(g[1] - target[1]);

            if (d <= max) {
                return false;
            }
        }

        return true;
    }
}