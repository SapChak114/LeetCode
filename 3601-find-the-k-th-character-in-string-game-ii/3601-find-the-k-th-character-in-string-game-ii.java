class Solution {
    public char kthCharacter(long k, int[] operations) {
        int n = operations.length;
        int count_ops = 0;
        long val = k;
        
        while (val > 1) {
            int jump = (int)Math.ceil(Math.log(val)/Math.log(2.0));
            val -= Math.pow(2, jump - 1);
            count_ops += operations[jump - 1];
        }

        return (char) ('a' + (count_ops%26));
    }
}