class Pair{
    char b;
    int wt;

    public Pair(char b, int wt) {
        this.b = b;
        this.wt = wt;
    }
}
class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        Map<Character, List<Pair>> adjMap = new HashMap<>();

        int n = original.length;
        for (int i = 0; i<n; i++) {
            char a = original[i];
            char b = changed[i];
            int wt = cost[i];

            adjMap.computeIfAbsent(a, k -> new ArrayList<>()).add(new Pair(b, wt));
        }

        int m = source.length(), val = 0;
        long sum = 0;
        Map<String, Integer> memo = new HashMap<>();
        for(int i = 0; i<m; i++) {
            char src = source.charAt(i);
            char dest = target.charAt(i);
            String key = src + "-" + dest;
            if (memo.containsKey(key)) {
                val = memo.get(key);
            } else {
                val = dijkstra(src, dest, adjMap);
                if (val == Integer.MAX_VALUE) {
                    return -1;
                }
                memo.put(key, val);
            }
            sum += val;
        }

        return sum;
    }

    int dijkstra(char src, char dest, Map<Character, List<Pair>> adjMap) {
        Map<Character, Integer> dist = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new Pair(src, 0));
        dist.put(src, 0);

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            char currChar = p.b;
            int currDist = p.wt;

            if (currChar == dest) {
                return currDist;
            }

            if (currDist > dist.getOrDefault(currChar, Integer.MAX_VALUE)) {
                continue;
            }

            if (!adjMap.containsKey(currChar)) {
                continue;
            }

            for (Pair nei : adjMap.get(currChar)) {
                int newDist = currDist + nei.wt;
                if (newDist < dist.getOrDefault(nei.b, Integer.MAX_VALUE)) {
                    pq.add(new Pair(nei.b, newDist));
                    dist.put(nei.b, newDist);
                }
            }
        }

        return Integer.MAX_VALUE;
    }
}
/**
Input: source = "abcd", target = "acbe", original = ["a", "b", "c", "c", "e", "d"], changed = ["b", "c", "b", "e", "b", "e"], cost = [2, 5, 5, 1, 2, 20]
 */