class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sumPower = 0;
        for (int power : batteries)
            sumPower += power;
        long left = 1, right = sumPower / n;
        
         while (left < right){
            long target = right - (right - left) / 2;
            long extra = 0;
            
            for (int power : batteries)
                extra += Math.min(power, target);

            if (extra >= (long)(n * target))
                left = target;
            else
                right = target - 1;
        }
        return left;
    }
    
    boolean check(long mins, int[] batteries, int n) {
        long total = 0;
        long computers = 0;
        for (int time : batteries) {
            total += time;
            if (total >= mins) {
                computers++;
                total -= mins;
            }
        }
        return computers >= n;
    }
}