class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }
        int start = 0, n = gas.length, sum = 0;

        for (int i = 0; i<n; i++) {
            sum += gas[i] - cost[i];

            if (sum < 0) {
                start = i+1;
                sum = 0;
            }
        }

        return start;
    }
}