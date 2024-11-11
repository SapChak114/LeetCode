class Solution {
    public boolean primeSubOperation(int[] nums) {
        if (checkIncreasing(nums)) {
            return true;
        }

        int n = nums.length;
        for (int i = 0; i<n; i++) {
            int elem = nums[i];
            int prime = findPrime(nums[i], (i == 0 ? 0 : nums[i-1]));
            nums[i] = elem - prime;
            if (checkIncreasing(nums)) {
                return true;
            }
        }

        return false;
    }

    boolean checkIncreasing(int[] nums) {
        int n = nums.length;
        for (int i = 1; i<n; i++) {
            if (nums[i - 1] >= nums[i]) {
                return false;
            }
        }
        return true;
    }

    int findPrime(int end, int prev) {
        for (int num = end-1; num >= 0; num--) {
            if ((end - num) > prev && isPrime(num)) {
                //System.out.println("prime "+num);
                return num;
            }
        }

        return 0;
    }

    boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}