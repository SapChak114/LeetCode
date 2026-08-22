class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        List<Integer>[] bucket = new ArrayList[n+1];

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int key = e.getKey();
            int val = e.getValue();

            if (bucket[val] == null) {
                bucket[val] = new ArrayList<>();
            }

            bucket[val].add(key);
        }

        int[] ans = new int[k];
        int j = 0;
        for (int i = bucket.length-1; i>=0; i--) {
            if (bucket[i] == null) {
                continue;
            }

            for (int num : bucket[i]) {
                if (j >= k) {
                    break;
                }
                ans[j++] = num;
            }
        }

        return ans;
    }
}