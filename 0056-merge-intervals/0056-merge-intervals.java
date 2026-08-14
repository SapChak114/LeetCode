class Solution {
    public int[][] merge(int[][] inter) {
        int n = inter.length;

        Arrays.sort(inter, (a,b)-> a[0]-b[0]);
        List<int[]> res = new ArrayList<>();
        int[] prev = inter[0];
        for (int i = 1; i<n; i++) {
            if (prev[1] >= inter[i][0]) {
                prev[1] = Math.max(prev[1], inter[i][1]);
            } else {
                res.add(prev);
                prev = inter[i];
            }
        }
        res.add(prev);

        int[][] ans = new int[res.size()][2];
        for (int i = 0; i<ans.length; i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}