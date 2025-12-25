class Solution {
    public long maximumHappinessSum(int[] hap, int k) {
        Arrays.sort(hap);
         
        long sum = 0;
        int idx = hap.length-1;
        for (int dec = 0; dec<k; dec++) {
            int val = hap[idx--];
            val -= dec;
            if (val < 0) {
                break;
            }
            sum += val;
        }

        return sum;
    }
}