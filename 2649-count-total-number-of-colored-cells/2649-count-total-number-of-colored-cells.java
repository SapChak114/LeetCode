class Solution {
    public long coloredCells(int n) {
        long numCell = 1;
        int added = 4;

        while (--n > 0) {
            numCell += added;
            added += 4;
        }

        return numCell;
    }
}