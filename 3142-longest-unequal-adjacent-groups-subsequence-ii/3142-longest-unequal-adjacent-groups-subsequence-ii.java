class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length, maxIndex = 0;
        int[] lis = new int[n];
        int[] prev = new int[n];
        Arrays.fill(lis, 1);
        Arrays.fill(prev, -1);

        for (int i = n-1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (check(words[i], words[j]) && (groups[i] != groups[j])
                                                     && (lis[i] < 1 + lis[j])) {
                    lis[i] = 1 + lis[j];
                    prev[i] = j;
                }
            }

            if (lis[i] > lis[maxIndex] ||            // strictly longer
    (lis[i] == lis[maxIndex] && i < maxIndex)) {   // same length, earlier start
    maxIndex = i;
}
        }

        List<String> ans = new ArrayList<>();
        for (int i = maxIndex; i != -1; i = prev[i]) {
            ans.add(words[i]);
        }
        return ans;
    }

    boolean check(String w1, String w2) {
        int n = w1.length(), m = w2.length();
        if (n != m) {
            return false;
        }

        int count = 0;
        for(int i = 0; i<n; i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }

        return count == 1;
    }
}