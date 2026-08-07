class Solution {
    public int[][] merge(int[][] inter) {
        int n = inter.length;

        Arrays.sort(inter, (a,b) -> a[0]-b[0]);

        int[] prev = inter[0];
        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i<n; i++) {
            if (prev[1] >= inter[i][0]) {
                prev[1] = Math.max(prev[1], inter[i][1]);
            } else {
                ans.add(prev);
                prev = inter[i];
            }
        }
        ans.add(prev);

        int[][] res = new int[ans.size()][2];
        for (int i = 0; i<ans.size(); i++) {
            res[i][0] = ans.get(i)[0];
            res[i][1] = ans.get(i)[1];
        }

        return res;
    }
}