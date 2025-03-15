class Solution {
    public String fractionToDecimal(int num, int denom) {
        StringBuilder sb = new StringBuilder();

        String sign = (num < 0 == denom < 0 || num == 0) ? "" : "-";

        long n = Math.abs((long) num);
        long d = Math.abs((long) denom);

        sb.append(sign);

        sb.append((n / d));

        long rem = n % d;

        if (rem == 0) {
            return sb.toString();
        }

        sb.append(".");

        Map<Long, Integer> remMap = new HashMap<>();

        while (!remMap.containsKey(rem)) {
            remMap.put(rem, sb.length());
            sb.append((10 * rem) / d);
            rem = (10 * rem) % d;
        }
        
        int repeated = remMap.get(rem);

        sb.insert(repeated, "(");

        sb.append(")");

        return sb.toString().replace("(0)", "");
    }
}