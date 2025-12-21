import java.util.List;
import java.util.Arrays;

class Solution {
    public int minDeletionSize(String[] words) {
        int n = words.length;
        boolean[] sortedPairs = new boolean[n - 1];
        int deletions = 0;

        for (int col = 0; col < words[0].length(); col++) {
            // Check if any unresolved pair violates sorting order
            boolean shouldDelete = false;
            for (int i = 0; i < n - 1; i++) {
                if (!sortedPairs[i] && words[i].charAt(col) > words[i + 1].charAt(col)) {
                    shouldDelete = true;
                    break;
                }
            }
            
            if (shouldDelete) {
                deletions++;
                continue;
            }

            // Mark pairs as sorted if this column confirms strict increase
            for (int i = 0; i < n - 1; i++) {
                if (!sortedPairs[i] && words[i].charAt(col) < words[i + 1].charAt(col)) {
                    sortedPairs[i] = true;
                }
            }
        }
        
        return deletions;
    }
}