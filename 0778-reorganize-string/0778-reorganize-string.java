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
            pq.add(new Pair(e.getKey(), e.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> freq2 = new HashMap<>();
        while (!pq.isEmpty()) {
            Pair p1 = pq.poll();
            if (!pq.isEmpty()) {
                sb.append(p1.c);
                freq2.put(p1.c, freq2.getOrDefault(p1.c, 0)+1);
                Pair p2 = pq.poll();
                sb.append(p2.c);
                freq2.put(p2.c, freq2.getOrDefault(p2.c, 0)+1);
                
                int newFreq1 = p1.freq - 1;
                if (newFreq1 > 0) {
                    pq.add(new Pair(p1.c, newFreq1));
                }
                int newFreq2 = p2.freq - 1;
                if (newFreq2 > 0) {
                    pq.add(new Pair(p2.c, newFreq2));
                }
            } else {
                int len = freq2.getOrDefault(p1.c, 0);
                System.out.println(len+" "+sb.length());
                if (len > sb.length()/2) {
                    return "";
                }
                sb.append(p1.c);
                freq2.put(p1.c, freq2.getOrDefault(p1.c, 0)+1);
                int newFreq1 = p1.freq - 1;
                if (newFreq1 > 0) {
                    pq.add(new Pair(p1.c, newFreq1));
                }
            }
            
        }

        return sb.toString();
    }
}