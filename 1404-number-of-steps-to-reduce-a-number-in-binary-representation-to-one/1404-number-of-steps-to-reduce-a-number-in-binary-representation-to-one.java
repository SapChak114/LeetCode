class Solution {
    public int numSteps(String s) {
        int ops = 0;

        StringBuilder sb = new StringBuilder(s);
        
        while (sb.length() > 1) {
            int n = sb.length();

            if (sb.charAt(n - 1) == '0') {
                divideByTwo(sb);
            } else {
                addOne(sb);
            }
            ops++;
        }

        return ops;
    }

    void divideByTwo(StringBuilder sb) {
        sb.deleteCharAt(sb.length() - 1);
    }

    void addOne(StringBuilder sb) {
        int i = sb.length() - 1;

        while (i >= 0 && sb.charAt(i) != '0') {
            sb.setCharAt(i, '0');
            i--;
        }

        if (i < 0) {
            sb.insert(0, '1');
        } else {
            sb.setCharAt(i, '1');
        }
    }
}