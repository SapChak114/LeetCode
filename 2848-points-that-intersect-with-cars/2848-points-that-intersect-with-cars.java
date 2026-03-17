class Interval {
    int s;
    int t;

    public Interval(int s, int t) {
        this.s = s;
        this.t = t;
    }
}
class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        List<Interval> intervals = new ArrayList<>();

        for (List<Integer> num : nums) {
            int s = num.get(0);
            int e = num.get(1);

            intervals.add(new Interval(s, 1));
            intervals.add(new Interval(e + 1, -1));
        }

        Collections.sort(intervals, (a,b) -> a.s == b.s ? Integer.compare(a.t, b.t) : Integer.compare(a.s, b.s));

        int prev = -1, total = 0, active = 0;
        for (Interval inter : intervals) {
            int start = inter.s;
            int delta = inter.t;

            if (prev != -1 && active > 0) {
                total += start - prev;
            }

            active += delta;
            prev = start;
        }

        return total;
    }
}