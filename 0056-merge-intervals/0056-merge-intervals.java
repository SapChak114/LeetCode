class Solution {
    public int[][] merge(int[][] inv) {
        int n = inv.length;
        
        int[] prev = inv[0];
        
        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i<inv.length; i++) {
            int[] in = inv[i];

            if (prev[1] >= in[0]) {
                prev[1] = Math.max(prev[1], in[1]);
            } else {
                ans.add(prev);
                prev = in;
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