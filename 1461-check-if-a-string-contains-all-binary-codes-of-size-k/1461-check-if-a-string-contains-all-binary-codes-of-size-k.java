class Solution {
    public boolean hasAllCodes(String s, int k) {
        int req = 1<<k;
        int n = s.length();

        Set<String> set = new HashSet<>();

        for (int i = 0; i<=n-k; i++) {
            //System.out.println((i)+" "+(i+k));
            String sub = s.substring(i, i+k);
            if (!set.contains(sub)) {
                set.add(sub);
                req--;
            }

            if (req == 0) {
                return true;
            }
        }

        return false;
    }
}