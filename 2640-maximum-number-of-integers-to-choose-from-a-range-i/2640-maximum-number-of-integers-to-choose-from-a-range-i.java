class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set set = new HashSet<>();
        for (int ban : banned) {
            set.add(ban);
        }

        int sum = 0, count = 0;
        for (int num = 1; num <= n; num++) {
            if (set.contains(num)) {
                continue;
            }

            if (maxSum - num < 0) {
                return count;
            }

            maxSum -= num;
            count++;
        }

        return count;
    }
}