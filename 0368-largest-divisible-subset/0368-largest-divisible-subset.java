class Solution {
    int n;
    int[] nums;
    Map<String, List<Integer>> dp;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        this.n = nums.length;
        this.nums = nums;
        this.dp = new HashMap<>();
        return dfs(0, 1);
    }

    List<Integer> dfs(int index, int prev) {
        if (index == n) {
            return new ArrayList<>();
        }

        String key = index+"-"+prev;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        List<Integer> res = dfs(index+1, prev);
        if ((nums[index] % prev) == 0) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[index]);
            temp.addAll(dfs(index+1, nums[index]));

            if (temp.size() > res.size()) {
                res = temp;
            }
        }

        dp.put(key, res);

        return res;
    }
}