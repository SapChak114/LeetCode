class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0, curr = 0, total = 0;

        for (String s : bank) {
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    curr++;
                }
            }

            total += (prev * curr);
            prev = curr == 0 ? prev : curr;
            curr = 0;
        }

        return total;
    }
}