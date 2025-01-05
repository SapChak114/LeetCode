class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = s.replaceAll("-","");
        int n = s.length();
        if (n == 0) {
            return "";
        }

        StringBuilder res = new StringBuilder();
        for (int i = n-1; i>=0; i-=k) {
            if (i >= k) {
                String sub = s.substring(i - k + 1, i+1).toUpperCase();
                // System.out.println(sub);
                res.insert(0, "-"+sub);
            } else {
                res.insert(0, s.substring(0, i+1).toUpperCase());
            }
        }   

        if (res.charAt(0) == '-') {
            res.deleteCharAt(0);
        }

        return res.toString();
    }
}