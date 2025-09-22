class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            maxFreq = Math.max(maxFreq, e.getValue());
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            if (e.getValue() == maxFreq) {
                count++;
            }
        }

        return count * maxFreq;
    }
}