class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length, i = 0;
        long sum = 0l;
        for (int ch : chalk) {
            sum += ch;
        }
        k = (int) (k % sum);
        while (true) {
            i %= n;
            if (chalk[i] > k) {
                return i;
            } else {
                k -= chalk[i];
            }
            i++;
        }
    }
}