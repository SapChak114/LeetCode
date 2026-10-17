class Solution {
    public String reorganizeString(String s) {
        char[] ch = s.toCharArray();

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : ch) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        //System.out.println(freq);
        PriorityQueue<Character> pq = new PriorityQueue<>(
                    (a, b) -> freq.get(b) - freq.get(a));

        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            if (e.getValue() > (s.length()+1)/2) {
                return "";
            }
            pq.add(e.getKey());
        }
        
        StringBuilder sb = new StringBuilder();
        char prev = '#';
        //System.out.println(pq);
        while (!pq.isEmpty()) {
            char c = pq.poll();
            //System.out.println(c);
            sb.append(c);

            if (freq.getOrDefault(prev, -1) > 0) {
                pq.add(prev);
            }

            freq.put(c, freq.get(c) - 1);
            prev = c;
        }

        return sb.toString();
    }
}