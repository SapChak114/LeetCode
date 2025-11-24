class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }

        int prev = 0;
        for (int i = 1; i<=nums.length; i++) {
            if (i == nums.length || nums[i-1] + 1 != nums[i]) {
                //System.out.println(nums[i]);
                if (prev == i-1) {
                    ans.add(""+nums[prev]);
                } else {
                    ans.add(nums[prev]+"->"+nums[i-1]);
                }
                prev = i;
            }
        }
        return ans;
    }
}

/*
prev = 0
0 + 1 = 1 == 1
1 + 1 == 2
2 + 1 != 4
0->2

prev = 4
4 
*/