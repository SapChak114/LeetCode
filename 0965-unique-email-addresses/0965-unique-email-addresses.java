class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String sub = email.substring(0, email.indexOf("@")).replaceAll("\\.","");
            if (sub.contains("+")) {
                sub = sub.substring(0, sub.indexOf("+"));
            }
            sub += email.substring(email.indexOf("@"));
            set.add(sub);
        }
        return set.size();
    }
}