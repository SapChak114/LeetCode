class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length, i = 0;

        List<String> ans = new ArrayList<>();
        for (i = 0; i<n-1; i++) {
            int st = nums[i];
            if (nums[i]+1 == nums[i+1]) {
                System.out.println(nums[i]);
                while (i < n-1 && (nums[i]+1 == nums[i+1])) {
                    i++;
                }
                ans.add(st+"->"+nums[i]);
            } else {
                ans.add(""+nums[i]);
            }
        }

        if (i != n) {
            ans.add(""+nums[i]);
        }

        return ans;
    }
}