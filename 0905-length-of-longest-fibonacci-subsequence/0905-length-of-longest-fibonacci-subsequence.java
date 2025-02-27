class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length, ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        for (int i = 0; i<n; i++) {
            for (int j = i+1; j<n; j++) {
                int prev = arr[i];
                int cur = arr[j];
                int nxt = prev + cur;
                int len = 2;

                while (set.contains(nxt)) {
                    len++;
                    prev = cur;
                    cur = nxt;
                    nxt = prev + cur;
                    ans = Math.max(ans, len);
                }
            }
        }

        return ans;
    }
}