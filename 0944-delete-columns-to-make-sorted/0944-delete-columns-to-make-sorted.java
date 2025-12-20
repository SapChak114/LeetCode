class Solution {
    public int minDeletionSize(String[] strs) {
        int count = 0;

        for (int i = 0; i<strs[0].length(); i++) {
            count += eval(strs, i);
        }

        return count;
    }

    int eval(String[] strs, int j) {
        for (int i = 1; i<strs.length; i++) {
            if (strs[i].charAt(j) < strs[i-1].charAt(j)) {
                return 1;
            }
        }

        return 0;
    }
}