class Solution {
    public int minimumBoxes(int[] apple, int[] cap) {
        sortReverse(cap);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int app : apple) {
            pq.add(app);
        }

        int ans = 0;
        for (int i = 0; i<cap.length; i++) {
            int val = cap[i];
            ans++;
            while (val > 0 && !pq.isEmpty()) {
                if (val >= pq.peek()) {
                    val -= pq.poll();
                } else {
                    int poll = pq.poll();
                    int rem = poll - val;
                    pq.add(rem);
                    val = 0;
                }
            }

            if (pq.isEmpty()) {
                break;
            }
        }

        return ans;

    }

    void sortReverse(int[] cap) {
        Arrays.sort(cap);
        int start = 0, end = cap.length-1;

        while (start < end) {
            int temp = cap[start];
            cap[start] = cap[end];
            cap[end] = temp;
            start++;
            end--;
        }
    }
}