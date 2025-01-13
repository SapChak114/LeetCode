class Solution {
    public int minimumLength(String s) {
        char[] ch = s.toCharArray();

        int res = 0;

        char[] nums = new char[26];
        for (int i = 0; i<ch.length; i++) {
            nums[ch[i] - 'a']++;
        }

        for (int i = 0; i<26; i++) {
            if (nums[i] == 0) {
                continue;
            } else if (nums[i] % 2 == 0) {
                res += 2;
            } else {
                res++;
            }
        }

        return res;
    }
}