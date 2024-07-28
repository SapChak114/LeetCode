class Pair{
    char c;
    int freq;
    public Pair(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }
}
class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        char[] ch = s.toCharArray();

        for (char c : ch) {
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);

        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            if (e.getValue() > (s.length()+1)/2) {
                return "";
            }
            pq.add(new Pair(e.getKey(), e.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        Pair prev = new Pair('#', -1);
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            sb.append(curr.c);

            if (prev.freq > 0) {
                pq.add(prev);
            }

            curr.freq--;
            prev = curr;
        }

        return sb.toString();
    }
}