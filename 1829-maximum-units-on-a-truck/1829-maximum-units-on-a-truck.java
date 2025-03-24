class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));

        int maxUnits = 0;
        for (int[] box : boxTypes) {
            int boxCount = box[0];
            int unitPerBox = box[1];
            
            if (truckSize >= boxCount) {
                maxUnits += boxCount * unitPerBox;
                truckSize -= boxCount;
            } else {
                maxUnits += truckSize * unitPerBox;
                break;
            }
        }

        return maxUnits;
    }
}