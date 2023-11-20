import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        return f("M", garbage, travel) + f("P", garbage, travel) + f("G", garbage, travel);
    }

    private int[] getA(String gtype, String[] garbage) {
        int[] A = new int[garbage.length];
        for (int i = 0; i < garbage.length; i++) {
            A[i] = countOccurrences(garbage[i], gtype);
        }

        int lastIndex = A.length - 1;
        while (lastIndex >= 0 && A[lastIndex] == 0) {
            lastIndex--;
        }

        return Arrays.copyOfRange(A, 0, lastIndex + 1);
    }

    private int countOccurrences(String str, String target) {
        int count = 0;
        int index = str.indexOf(target);
        while (index != -1) {
            count++;
            index = str.indexOf(target, index + 1);
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
