class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int n = time.length, count = 0;

        int[] remainder = new int[60];
        for (int t : time) {
            int mod = t % 60;
            int compliment = (60 - mod) % 60;
            count += remainder[compliment];
            remainder[mod]++;
        }

        return count;
    }
}