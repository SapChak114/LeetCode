class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        List<String> res = new ArrayList<>();

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> freq.get(a) == freq.get(b) ? b.compareTo(a) : freq.get(a) - freq.get(b));

        for (String word : freq.keySet()) {
            pq.add(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }

        Collections.reverse(res);

        return res;
    }
}