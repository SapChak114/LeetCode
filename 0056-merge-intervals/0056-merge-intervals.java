class Solution {
    public int[][] merge(int[][] inv) {
        int n = inv.length;

        Arrays.sort(inv, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();

        int[] prev = inv[0];
        for (int i = 1; i<n; i++) {
            int[] iv = inv[i];

            if (iv[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], iv[1]);
            } else {
                res.add(prev);
                prev = iv;
            }
        }

        res.add(prev);

        int[][] a = new int[res.size()][2];
        for (int i = 0; i<res.size(); i++) {
            a[i][0] = res.get(i)[0];
            a[i][1] = res.get(i)[1];
        }

        return a;
    }
}