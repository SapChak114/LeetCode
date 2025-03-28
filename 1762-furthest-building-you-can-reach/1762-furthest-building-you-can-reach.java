class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i<n-1; i++) {
            int diff = heights[i+1] - heights[i];

            if (diff <= 0) {
                continue;
            }

            bricks -= diff;
            maxHeap.add(diff);
            if (bricks < 0) {
                if (ladders == 0) {
                    return i;
                }
                ladders--;
                bricks += maxHeap.poll();
            }
        }

        return n-1;
    }
}