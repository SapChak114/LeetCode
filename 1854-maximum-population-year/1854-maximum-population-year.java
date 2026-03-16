class Interval {
    int start;
    int time;

    public Interval(int start, int time) {
        this.start = start;
        this.time = time;
    }
}

class Solution {
    public int maximumPopulation(int[][] logs) {
        List<Interval> vals = new ArrayList<>();

        for (int[] log : logs) {
            int start = log[0];
            int end = log[1];

            vals.add(new Interval(start, 1));
            vals.add(new Interval(end, -1));
        }

        Collections.sort(vals, (a, b) -> a.start == b.start ? Integer.compare(a.time, b.time) : Integer.compare(a.start, b.start));

        int maxTime = 0;
        int maxVal = 0;
        int val = 0;
        for (Interval inter : vals) {
            int yr = inter.start;
            int line = inter.time;

            val += line;

            if (val > maxVal) {
                maxVal = val;
                maxTime = yr;
            }
        }

        return maxTime;
    }
}