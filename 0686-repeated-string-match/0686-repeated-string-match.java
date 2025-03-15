class Solution {
    public int repeatedStringMatch(String a, String b) {
        int n = b.length();

        int repeat = (n + a.length() -1) / a.length();
        StringBuilder sb = new StringBuilder(a.repeat(repeat));

        if (sb.toString().contains(b)) {
            return repeat;
        }

        sb.append(a);
        if (sb.toString().contains(b)) {
            return repeat + 1;
        }

        return -1;
    }
}