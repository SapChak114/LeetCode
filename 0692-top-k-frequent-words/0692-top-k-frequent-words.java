class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> freq.get(a) == freq.get(b) ? b.compareTo(a) : freq.get(a) - freq.get(b));

        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            pq.add(e.getKey());
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }

        Collections.reverse(ans);

        return ans;
    }
}