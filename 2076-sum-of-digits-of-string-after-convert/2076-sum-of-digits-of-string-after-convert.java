class Solution {
    public int getLucky(String s, int k) {
        char[] ch = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
            sb.append((c - 'a' + 1));
        }

        int sum = findSum(sb.toString());

        for (int i = 1; i<k; i++) {
            sum = findSum(String.valueOf(sum));
        }

        return sum;
    }

    int findSum(String val) {
        int sum = 0;

        for (char c : val.toCharArray()) {
            sum += c-'0';
        }

        return sum;
    }
}