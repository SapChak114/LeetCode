class Solution {
    public List<String> summaryRanges(int[] nums) {
        int left = 0;
        List<String> ans = new ArrayList<>();

        if ((nums.length == 1) || (nums.length > 1 && nums[0]+1 != nums[1])) {
            ans.add(""+nums[0]);
            left = 1;
        }
        if (nums.length == 2) {
            List<String> li = new ArrayList<>();
            if (nums[0] + 1 == nums[1]) {
                li.add(nums[0]+"->"+nums[1]);
                return li;
            } else {
                li.add(""+nums[0]);
                li.add(""+nums[1]);
                return li;
            }
        }
        for (int i = 2; i<nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                if (i == nums.length - 1) {
                    ans.add(nums[left]+"->"+nums[i]);
                }
                continue;
            }
            if (left == i-1) {
                //System.out.println("same "+i);
                ans.add(""+nums[left]);
            } else {
                //System.out.println(i);
                ans.add(nums[left]+"->"+nums[i-1]);
            }
            
            left = i;
            // System.out.println(i+" "+left);
            // System.out.println();
            if (i == nums.length - 1) {
                ans.add(""+nums[i]);
            }
        }

        return ans;
    }
}