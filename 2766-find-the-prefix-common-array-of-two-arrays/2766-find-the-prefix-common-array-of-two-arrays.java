class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Map<Integer, Integer> hm = new HashMap<>();

        int n = A.length, count = 0;
        int[] res = new int[n];
        for (int i = 0; i<n; i++) {
            for (int num : Arrays.asList(A[i], B[i])) {
                hm.put(num, hm.getOrDefault(num, 0) + 1);
                if (hm.get(num) == 2) {
                    count++;
                }
            }
            res[i] = count;
        }

        return res;
    }
}