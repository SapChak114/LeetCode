class Solution {
    int count;
    boolean[] vis;
    int n;
    public int countArrangement(int n) {
        this.count = 0;
        this.n = n;
        this.vis = new boolean[n + 1];
        back(1);
        return count;
    }

    void back(int pos) {
        if (pos > n) {
            count++;
        }

        for (int i = 1; i<=n; i++) {
            if (!vis[i] && ((i % pos) == 0 || (pos % i) == 0)) {
                vis[i] = true;
                back(pos + 1);
                vis[i] = false;
            }
        }
    }
}