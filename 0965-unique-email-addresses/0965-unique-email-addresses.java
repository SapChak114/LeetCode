class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int endIdx = email.indexOf("@");
            email = email.substring(0, endIdx).replaceAll("\\.", "")+email.substring(endIdx);
            int idx = email.indexOf("+");
            if (idx != -1) {
                endIdx = email.indexOf("@");
                if (idx < endIdx) {
                    String subString = email.substring(idx, endIdx);
                    email = email.replace(subString, "");
                }

            }

            set.add(email);
        }

        System.out.println(set);
        return set.size();
    }
}