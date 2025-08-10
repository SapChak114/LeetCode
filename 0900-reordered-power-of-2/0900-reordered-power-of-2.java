class Solution {
    public boolean reorderedPowerOf2(int n) {
        String nVal = sorted(n);
        for (int i = 0; i<31; i++) {
            if (sorted(1 << i).equals(nVal)) {
                return true;
            }
        }

        return false;
    }

    public String sorted(int n) {
        char[] charSeq = String.valueOf(n).toCharArray();
        Arrays.sort(charSeq);
        return new String(charSeq);
    }
}