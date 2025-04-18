class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] state = new int[len];

        for (int i = 0; i<len; i++) {
            state[i] = getStateFromString(words[i]);
        }

        int maxProduct = 0;
        for (int i = 0; i<len; i++) {
            for (int j = 0; j<len; j++) {
                if ((state[i] & state[j]) == 0) {
                    if ((words[i].length() * words[j].length()) > maxProduct) {
                        maxProduct = (words[i].length() * words[j].length());
                    }
                }
            }
        }

        return maxProduct;
    }

    int getStateFromString(String s) {
        int state = 0; 
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            state |= 1 << (idx);
        }
        return state;
    }
}