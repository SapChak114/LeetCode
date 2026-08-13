class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[n + 1];
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int key = e.getKey();
            int value = e.getValue();

            if (bucket[value] == null) {
                bucket[value] = new ArrayList<>();
            }

            bucket[value].add(key);
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