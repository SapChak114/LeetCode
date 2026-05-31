class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        List<Integer>[] bucket = new ArrayList[n+1];

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int key = e.getKey();
            int val = e.getValue();

            if (bucket[val] == null) {
                bucket[val] = new ArrayList<>();
            }

            bucket[val].add(key);
        }

        int[] ans = new int[k];
        int idx = 0;
        for (int i = bucket.length-1; i>=0 && idx<k; i--) {
            
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    ans[idx++] = num;

                    if (idx == k) {
                        break;
                    }
                }
            }
        }

        return ans;
    }
}