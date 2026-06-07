class Solution {
    int n, m;
    int[][] h;
    public List<List<Integer>> pacificAtlantic(int[][] h) {
        this.n = h.length;
        this.m = h[0].length;
        this.h = h;

        boolean[][] pac = new boolean[n][m];
        boolean[][] atl = new boolean[n][m];

        for (int r = 0; r<n; r++) {
            dfs(r, 0, pac, h[r][0]);
            dfs(r, m-1, atl, h[r][m-1]);
        }

        for (int c = 0; c<m; c++) {
            dfs(0, c, pac, h[0][c]);
            dfs(n-1, c, atl, h[n-1][c]);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (pac[i][j] && atl[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    void dfs(int r, int c, boolean[][] vis, int prevHeight) {
        if (r < 0 || r >= n || c < 0 || c >= m || vis[r][c] || h[r][c] < prevHeight) {
            return;
        }

        vis[r][c] = true;

        dfs(r+1, c, vis, h[r][c]);
        dfs(r, c+1, vis, h[r][c]);
        dfs(r-1, c, vis, h[r][c]);
        dfs(r, c-1, vis, h[r][c]);
    }
}