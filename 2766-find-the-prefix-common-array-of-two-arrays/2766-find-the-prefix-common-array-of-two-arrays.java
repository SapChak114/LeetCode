class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        int n = A.length;
        int[] res = new int[n];
        for (int i = 0; i<n; i++) {
            setA.add(A[i]);
            setB.add(B[i]);
            Set<Integer> inter = new HashSet<>(setA);
            inter.retainAll(setB);
            res[i] = inter.size();
        }

        return res;
    }
}