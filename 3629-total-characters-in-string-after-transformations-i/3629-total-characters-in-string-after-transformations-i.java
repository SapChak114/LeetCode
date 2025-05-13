class Solution {
    int MOD = (int) (1e9 + 7);
    public int lengthAfterTransformations(String s, int t) {
        int[] cnt = new int[26];

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        for (int i = 0; i < t; i++) {
            int[] temp = new int[26];

            for (int j = 0; j < 26; j++) {
                int freq = cnt[j];
                if (freq == 0) continue;

                if (j != 25) { // 'a' to 'y'
                    temp[j + 1] = (temp[j + 1] + freq) % MOD;
                } else { // 'z' transforms to 'a' and 'b'
                    temp[0] = (temp[0] + freq) % MOD;
                    temp[1] = (temp[1] + freq) % MOD;
                }
            }

            cnt = temp;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans = (ans + cnt[i]) % MOD;
        }

        return ans;
    }
}