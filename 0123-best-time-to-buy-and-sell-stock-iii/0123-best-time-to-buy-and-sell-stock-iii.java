class Solution {
    public int maxProfit(int[] prices) {
        int b1 = Integer.MAX_VALUE, b2 = Integer.MAX_VALUE, s1 = 0, s2 = 0;

        for (int price : prices) {
            b1 = Math.min(b1, price);
            s1 = Math.max(s1, price - b1);
            b2 = Math.min(b2, price - s1);
            s2 = Math.max(s2, price - b2);
        }

        return s2;
    }
}