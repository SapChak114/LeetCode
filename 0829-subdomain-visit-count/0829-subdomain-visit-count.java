class Solution {
    public List<String> subdomainVisits(String[] cp) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> seen = new HashMap<>();

        int n = cp.length;
        for (int i = 0; i<n; i++) {
            String[] splittedVal = cp[i].split(" ");
            String times = splittedVal[0];
            String domain = splittedVal[1];
            int m = domain.length();

            for (int j = m-1; j>=0; j--) {
                if (domain.charAt(j) == '.') {
                    String subDomain = domain.substring(j+1);
                    int count = seen.getOrDefault(subDomain, 0);
                    int totalCount = count + Integer.valueOf(times);
                    seen.put(subDomain, totalCount);
                } else if (j == 0) {
                    int count = seen.getOrDefault(domain, 0);
                    int totalCount = count + Integer.valueOf(times);
                    seen.put(domain, totalCount);
                }
            }
        }

        for (Map.Entry<String, Integer> e : seen.entrySet()) {
            ans.add(e.getValue()+" "+e.getKey());
        }

        return ans;
    }
}