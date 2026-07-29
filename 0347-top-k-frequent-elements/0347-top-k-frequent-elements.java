class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> frq = new HashMap<>();

        for (int num : nums) {
            frq.put(num, frq.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[n+1];

        for (Map.Entry<Integer, Integer> e : frq.entrySet()) {
            int key = e.getKey();
            int val = e.getValue();
            
            if (bucket[val] == null) {
                bucket[val] = new ArrayList<>();
            }

            bucket[val].add(key);
        }

        int[] ans = new int[k];

        int j = 0;
        for (int i = bucket.length-1; i>=0 && j<k; i--) {
            
            if (bucket[i] == null) {
                continue;
            }

            for (int val : bucket[i]) {
                ans[j++] = val;

                if (j >= k) {
                    break;
                }
            }
        }

        return ans;
    }
}