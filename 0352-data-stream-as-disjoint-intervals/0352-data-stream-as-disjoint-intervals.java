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
            return new int[0][2];
        }

        List<int[]> intervals = new ArrayList<>();
        Iterator<Integer> it = values.iterator();
        int start = it.next();
        int end = start;

        while (it.hasNext()) {
            int curr = it.next();
            if (curr == end + 1) {
                end = curr;
            } else {
                intervals.add(new int[] {start, end});
                start = curr;
                end = curr;
            }
        }
        intervals.add(new int[] {start, end});

        return intervals.toArray(new int[0][]);
    }
}