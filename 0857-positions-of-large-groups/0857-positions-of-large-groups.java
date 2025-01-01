class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        int last = 0;
        s += "#";
        List<List<Integer>> ans = new ArrayList<>();
        int total = 1;
        int n = s.length();
        for (int i = 1; i<n; i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                total++;
            } else {
                if (total >= 3) {
                    List<Integer> li = new ArrayList<>();
                    li.add(last);
                    li.add(i-1);
                    ans.add(li);
                }
                total=1;
                last=i;
            }
        }
        return ans;
    }
}