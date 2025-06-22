class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> ans = new ArrayList<>();

        char[] ch = s.toCharArray();
        int n = ch.length;
        for (int i = 0; i<n; i += k) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j<i+k && j<n; j++) {
                sb.append(""+ch[j]);
            }

            if (sb.length() != k) {
                while (sb.length() < k) {
                    sb.append(""+fill);
                }
            }
            ans.add(sb.toString());
        }

        String[] res = new String[ans.size()];
        for (int i = 0; i<ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }
}