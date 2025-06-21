class Solution {
    public int minimumDeletions(String word, int k) {
        Map<Character, Integer> freqs = new HashMap<>();
        int res = word.length();

        for (char c : word.toCharArray()) {
            freqs.put(c, freqs.getOrDefault(c, 0) + 1);
        }

        for (int baseFreq : freqs.values()) {
            int deleted = 0;
            for (int freq : freqs.values()) {
                if (freq < baseFreq) {
                    deleted += freq;
                } else if (freq > baseFreq + k) {
                    deleted += freq - (baseFreq + k);
                }
            }

            res = Math.min(res, deleted);
        }

        return res;
    }
}