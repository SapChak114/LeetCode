class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        s += '#';
        List<List<Integer>> ans = new ArrayList<>();
        char[] ch = s.toCharArray();
        int n = ch.length, total = 1, last = 0;
        for (int i = 1; i<n; i++) {
            if (ch[i] == ch[i-1]) {
                total++;
            } else if (total >= 3) {
                List<Integer> li = new ArrayList<>();
                li.add(last);
                li.add(i-1);
                ans.add(li);

                total = 1;
                last = i;
            } else {
                last = i;
                total = 1;
            }
        }

        return ans;
    }
}