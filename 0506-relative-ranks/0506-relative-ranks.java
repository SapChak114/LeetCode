class Pair implements Comparable<Pair>{
    int idx;
    int num;

    public Pair(int idx, int num) {
        this.idx = idx;
        this.num = num;
    }

    public int compareTo(Pair other) {
        if (this.num == other.num) {
            return Integer.compare(this.idx, other.idx);
        }

        return Integer.compare(other.num, this.num);
    }
}
class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;

        List<Pair> list = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            list.add(new Pair(i, score[i]));
        }

        Collections.sort(list);

        String[] res = new String[n];
        for (int i = 0; i<n; i++) {
            Pair p = list.get(i);
            if (i == 0) {
                res[p.idx] = "Gold Medal";
            } else if (i == 1) {
                res[p.idx] = "Silver Medal";
            } else if (i == 2) {
                res[p.idx] = "Bronze Medal";
            } else {
                res[p.idx] = Integer.toString(i + 1);
            }
        }

        return res;
    }
}