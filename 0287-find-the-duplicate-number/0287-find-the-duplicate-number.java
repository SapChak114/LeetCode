class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n+1];

        for (int num : nums) {
            if (freq[num] == 0) {
                freq[num]++;
            } else {
                return num;
            }
        }

        return -1;
    }
}