class Solution {
    public int minimizeXor(int num1, int num2) {
        int setBit = Integer.bitCount(num2);
        int x = 0;

        for (int bits = 31; bits>=0; bits--) {
            if ((((num1 >> bits) & 1) == 1) && setBit > 0) {
                setBit--;
                x |= (1 << bits);
            }
        }

        for (int bits = 0; bits<=31; bits++) {
            if (setBit > 0 && ((x >> bits) & 1) == 0) {
                setBit--;
                x |= (1<<bits);
            }
        }

        return x;
        
    }
}