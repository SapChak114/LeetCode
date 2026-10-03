class Solution {
    public int[][] intervalIntersection(int[][] al, int[][] bl) {
        List<int[]> res = new ArrayList<>();

        int a = 0, b = 0, aLen = al.length, bLen = bl.length;

        while (a < aLen && b < bLen) {
            if (al[a][1] >= bl[b][0] && al[a][0] <= bl[b][1]) {
                int first = Math.max(al[a][0], bl[b][0]);
                int second = Math.min(al[a][1], bl[b][1]);
                res.add(new int[]{first, second});
            }

            if (al[a][1] > bl[b][1]) {
                b++;
            } else {
                a++;
            }
        }

        int[][] ans = new int[res.size()][2];
        for (int i = 0; i<ans.length; i++) {
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }

        return ans;
    }
}