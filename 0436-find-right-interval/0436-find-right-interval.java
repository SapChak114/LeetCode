class Solution {
    public int[] findRightInterval(int[][] inter) {
        int n = inter.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i<n; i++) {
            map.put(inter[i][0], i);
        }

        int[] ans = new int[n];
        for (int i = 0; i<n; i++) {
            Integer nextGreaterKey = map.ceilingKey(inter[i][1]);
            ans[i] = nextGreaterKey == null ? -1 : map.get(nextGreaterKey);
        }

        return ans;
    }
}