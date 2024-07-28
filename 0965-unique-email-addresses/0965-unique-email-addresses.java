class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String s : emails) {
            StringBuilder sb = new StringBuilder();
            int idx = s.indexOf("@");
            for (int i = 0; i<=idx; i++) {
                if (s.charAt(i) != '.') {
                    if (s.charAt(i) == '+') {
                        sb.append(s.charAt(idx));
                        break;
                    }
                    // System.out.print(s.charAt(i)+" ");
                    sb.append(s.charAt(i));
                }
            }
            for (int i = idx+1; i<s.length(); i++) {
                sb.append(s.charAt(i));
            }
            set.add(sb.toString());
            System.out.println();
        }
        System.out.println(set);
        return set.size();
    }
}