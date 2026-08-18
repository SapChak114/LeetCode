class SummaryRanges {
    private TreeSet<Integer> values;

    public SummaryRanges() {
        values = new TreeSet<>();
    }

    public void addNum(int value) {
        values.add(value);
    }

    public int[][] getIntervals() {
        if (values.isEmpty()) {
            return new int[][]{};
        }

        Iterator<Integer> itr = values.iterator();
        int start = itr.next();
        int end = start;

        List<int[]> ans = new ArrayList<>();
        while (itr.hasNext()) {
            int curr = itr.next();
            if (curr == end + 1) {
                end = curr;
            } else {
                ans.add(new int[]{start, end});
                start = curr;
                end = curr;
            }
        }

        ans.add(new int[]{start, end});

        int[][] res = new int[ans.size()][2];
        for (int i = 0; i<ans.size(); i++) {
            res[i][0] = ans.get(i)[0];
            res[i][1] = ans.get(i)[1];
        }

        return res;
    }
}