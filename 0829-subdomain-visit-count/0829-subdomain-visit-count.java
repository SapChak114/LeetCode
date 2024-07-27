class Solution {
    public List<String> subdomainVisits(String[] cp) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> seen = new HashMap<>();

        int n = cp.length;
        for (int i = 0; i<n; i++) {
            String[] splittedVal = cp[i].split("\\s");
            int times = Integer.parseInt(splittedVal[0]);
            String[] domains = splittedVal[1].split("\\.");
            int m = domains.length;
            String curr = "";
            for (int j = m-1; j>=0; j--) {
                curr = domains[j] + (curr.isEmpty() ? "" : ".") + curr;
                seen.put(curr, seen.getOrDefault(curr, 0) + times);
            }
        }

        for (Map.Entry<String, Integer> e : seen.entrySet()) {
            ans.add(e.getValue()+" "+e.getKey());
        }

        return ans;
    }
}