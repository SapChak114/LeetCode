class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        int n = intervals.length;

        for (int[] inter : intervals) {
            List<Integer> li = new ArrayList<>();
            li.add(inter[0]);
            li.add(inter[1]);
            res.add(li);
        }

        res.add(List.of(newInterval[0], newInterval[1]));

        Collections.sort(res, (a, b) -> a.get(0) - b.get(0));

        int i = 0;
        while (i < res.size()) {
            int start = res.get(i).get(0);
            int end = res.get(i).get(1);

            i++;
            while (i < res.size() && end >= res.get(i).get(0)) {
                end = Math.max(end, res.get(i).get(1));
                i++;
            }

            ans.add(List.of(start, end));
        }

        int[][] re = new int[ans.size()][2];
        for (i = 0; i<ans.size(); i++) {
            re[i][0] = ans.get(i).get(0);
            re[i][1] = ans.get(i).get(1);
        }

        return re;
    }
}