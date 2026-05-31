class Solution {
    public int[][] merge(int[][] in) {
        int n = in.length;

        Arrays.sort(in, (a,b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();
        int[] prev = in[0];
        for (int i = 1; i<n; i++) {
            if (prev[1] >= in[i][0]) {
                prev[1] = Math.max(prev[1], in[i][1]);
            } else {
                list.add(prev);
                prev = in[i];
            }
        }
        list.add(prev);

        int[][] ans = new int[list.size()][2];
        for (int i = 0; i<list.size(); i++) {
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }

        return ans;
    }
}