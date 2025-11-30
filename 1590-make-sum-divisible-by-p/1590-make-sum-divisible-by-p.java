class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }


        long target = sum % p;

        //System.out.println(target+" "+sum);
        if (target == 0) {
            return 0;
        }

        Map<Long, Integer> modMap = new HashMap<>();
        modMap.put(0L, -1); // To handle the case where the whole prefix is the answer

        long currMod = 0;
        long minLen = n;

        for (int i = 0; i<n; i++) {
            currMod = (currMod + nums[i]) % p;
            long needed = (currMod - target + p) % p;

            if (modMap.containsKey(needed)) {
                minLen = Math.min(minLen, i - modMap.get(needed));
            }

            modMap.put(currMod, i);
        }

        return minLen == n ? -1 : (int)minLen;
    }
}