class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int m = img1[0].length;

        List<int[]> list1 = new ArrayList<>(), list2 = new ArrayList<>();

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                if (img1[i][j] == 1) {
                    list1.add(new int[]{i, j});
                }
                if (img2[i][j] == 1) {
                    list2.add(new int[]{i, j});
                }
            }
        }

        Map<String, Integer> counter = new HashMap<>();
        int res = 0;
        for (int[] num1 : list1) {
            for (int[] num2 : list2) {
                int r = num2[0]-num1[0];
                int c = num2[1]-num1[1];
                String key = r + "," + c;
                int val = counter.getOrDefault(key, 0) + 1;
                res = Math.max(res, val);
                counter.put(key, val);
            }
        }

        return res;
    }
}