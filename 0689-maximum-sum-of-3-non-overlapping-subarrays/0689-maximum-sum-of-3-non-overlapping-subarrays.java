class Pair implements Comparable<Pair> {
    long total;
    List<Integer> ids;

    public Pair(long total, List<Integer> ids) {
        this.total = total;
        this.ids = ids;
    }

    @Override
    public int compareTo(Pair other) {
        if (this.total == other.total) {
            int length = Math.min(this.ids.size(), other.ids.size());
            for (int i = 0; i < length; i++) {
                if (this.ids.get(i) < other.ids.get(i)) {
                    return -1;
                } else if (this.ids.get(i) > other.ids.get(i)) {
                    return 1;
                }
            }
            return Integer.compare(this.ids.size(), other.ids.size());
        }
        return Long.compare(other.total, this.total);
    }
}

class Solution {
    int[] A;
    int k;
    List<Long> P;
    Map<String, Pair> dp;

    Pair dfs(int i, int cnt) {
        if (i >= A.length || cnt == 3) {
            return new Pair(0L, new ArrayList<>());
        }

        String key = i + "-" + cnt;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        Pair take = new Pair(0L, new ArrayList<>());
        if (i + k <= A.length) {
            take = dfs(i + k, cnt + 1);
            take = new Pair(take.total + P.get(i + k) - P.get(i), new ArrayList<>(take.ids));
            take.ids.add(0, i);
        }

        Pair dont = dfs(i + 1, cnt);

        Pair ans = (dont.compareTo(take) > 0) ? take : dont;
        dp.put(key, ans);
        return ans;
    }

    public int[] maxSumOfThreeSubarrays(int[] A, int k) {
        this.A = A;
        this.k = k;
        this.P = new ArrayList<>();
        this.dp = new HashMap<>();
        P.add(0L);

        for (int val : A) {
            P.add(P.get(P.size() - 1) + val);
        }

        List<Integer> ids = dfs(0, 0).ids;

        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            result[i] = ids.get(i);
        }
        return result;
    }
}