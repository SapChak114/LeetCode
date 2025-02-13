class Solution {
    public int maximumSum(int[] nums) {
        int[] digitMapping = new int[82];
        int result = -1;

        for (int num : nums) {
            int digitSum = 0;

            for (int currVal = num; currVal != 0; currVal /= 10) {
                int currDigit = currVal % 10;
                digitSum += currDigit;
            }

            if (digitMapping[digitSum] > 0) {
                result = Math.max(result, digitMapping[digitSum] + num);
            }

            digitMapping[digitSum] = Math.max(digitMapping[digitSum], num);
        }

        return result;
    }
}