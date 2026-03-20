class Solution {
    public int findMinArrowShots(int[][] points) {
        List<int[]> pList = new ArrayList<>();

        for (int[] point : points) {
            pList.add(new int[]{point[0], point[1]});
        }

        Collections.sort(pList, (a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        int prev = (int) pList.get(0)[1], val = 1;
        for (int i = 1; i<pList.size(); i++) {
            int[] point = pList.get(i);
            int start = point[0];
            int end = point[1];

            if (start > prev) {
                val++;
                prev = end;
            }
        }

        return val;
    }
}