import java.util.List;

class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        return f("M", garbage, travel) + f("P", garbage, travel) + f("G", garbage, travel);
    }
    
    private int[] getA(String gtype, String[] garbage) {
        int[] A = new int[garbage.length];
        for (int i = 0; i < garbage.length; i++) {
            A[i] = countOccurrences(gtype, garbage[i]);
        }
        
        int endIndex = A.length - 1;
        while (endIndex >= 0 && A[endIndex] == 0) {
            endIndex--;
        }

        int[] trimmedA = new int[endIndex + 1];
        if (endIndex >= 0) {
            System.arraycopy(A, 0, trimmedA, 0, endIndex + 1);
        }
        
        return trimmedA;
    }
    
    private int countOccurrences(String gtype, String house) {
        int count = 0;
        for (int i = 0; i < house.length(); i++) {
            if (house.charAt(i) == gtype.charAt(0)) {
                count++;
            }
        }
        return count;
    }
    
    private int f(String gtype, String[] garbage, int[] travel) {
        int[] A = getA(gtype, garbage);
        int time = 0;
        for (int i = 0; i < A.length; i++) {
            time += A[i];
            if (i != A.length - 1) {
                time += travel[i];
            }
        }
        return time;
    }
}