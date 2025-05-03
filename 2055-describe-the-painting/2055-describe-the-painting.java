class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        TreeMap<Long, Long> map = new TreeMap<>();

        for (int[] seg : segments) {
            long start = seg[0], end = seg[1], color = seg[2];
            map.put(start, map.getOrDefault(start, 0L) + color);
            map.put(end, map.getOrDefault(end, 0L) - color);
        }

        List<List<Long>> result = new ArrayList<>();
        long prevTime = 0;
        long totalColor = 0;

        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            long currTime = entry.getKey();
            if (totalColor != 0) {
                result.add(Arrays.asList(prevTime, currTime, totalColor));
            }
            totalColor += entry.getValue();
            prevTime = currTime;
        }

        return result;
    }
}
