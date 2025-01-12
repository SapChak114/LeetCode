class Pair implements Comparable<Pair>{
    int num;
    int idx;

    public Pair(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }

    public int compareTo(Pair other) {
        if (this.num == other.num) {
            return Integer.compare(other.idx, this.idx);
        }
        return Integer.compare(other.num, this.num);
    }
}
class Solution {
    public String[] findRelativeRanks(int[] score) {
        List<Pair> list = new ArrayList<>();
        int n = score.length;

        for (int i = 0; i<n; i++) {
            list.add(new Pair(score[i], i));
        }

        Collections.sort(list);

        String[] sb = new String[n];
        for (int i = 0; i<n; i++) {
            Pair p = list.get(i);
            if (i == 0) {
                sb[p.idx] = "Gold Medal";
            } else if (i == 1) {
                sb[p.idx] = "Silver Medal";
            } else if (i == 2) {
                sb[p.idx] = "Bronze Medal";
            } else {
                sb[p.idx] = Integer.toString(i + 1);
            }
        }

        return sb;
    }
}