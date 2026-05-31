class Solution {
    public int[][] insert(int[][] in, int[] newInv) {
        List<int[]> res = new ArrayList<>();

        int n = in.length;
        for (int i = 0; i<n; i++) {
            int[] inv = in[i];

            if (inv[1] < newInv[0]) {
                res.add(inv);
            } else if (newInv[1] < inv[0]) {
                res.add(newInv);
                newInv = inv;
            } else {
                newInv[0] = Math.min(newInv[0], inv[0]);
                newInv[1] = Math.max(newInv[1], inv[1]);
            }
        }
        res.add(newInv);

        int[][] ans = new int[res.size()][2];
        for (int i = 0; i<res.size(); i++) {
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }

        return ans;
    }
 }