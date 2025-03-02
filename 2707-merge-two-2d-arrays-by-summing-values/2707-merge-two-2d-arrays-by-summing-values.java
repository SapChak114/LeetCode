class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int[] num : nums1) {
            map.put(num[0], num[1]);
        }

        for (int[] num : nums2) {
            map.put(num[0], map.getOrDefault(num[0], 0) + num[1]);
        }

        List<int[]> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            ans.add(new int[]{e.getKey(), e.getValue()});
        }

        int[][] res = new int[ans.size()][2];
        for (int i = 0; i<ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}