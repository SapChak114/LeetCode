import java.util.*;

public class Solution {

    private Map<String, Integer> dp;
    private List<Map<Character, Integer>> stickCount;

    public int minStickers(String[] stickers, String target) {
        // Initialize the sticker character counts
        stickCount = new ArrayList<>();
        for (String s : stickers) {
            Map<Character, Integer> countMap = new HashMap<>();
            for (char c : s.toCharArray()) {
                countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            }
            stickCount.add(countMap);
        }

        // Initialize the memoization map
        dp = new HashMap<>();
        dp.put("", 0);  // Base case: 0 stickers are needed for an empty target

        // Start the recursive DFS from the full target string
        int result = dfs(target);

        // Return the result (if impossible, return -1)
        return result == (int)1e9+7 ? -1 : result;
    }

    // DFS helper method
    private int dfs(String t) {
        // Check if the result for this target subsequence is already computed
        if (dp.containsKey(t)) {
            return dp.get(t);
        }

        // Result starts as infinite (because we are looking for the minimum)
        int res = (int)1e9+7;

        // Try to use each sticker to reduce the target
        for (Map<Character, Integer> sticker : stickCount) {
            // If the first character of the target doesn't exist in the current sticker, skip it
            if (!sticker.containsKey(t.charAt(0))) {
                continue;
            }

            // Build the new target string (remaining part)
            StringBuilder remainT = new StringBuilder();
            Map<Character, Integer> tempSticker = new HashMap<>(sticker);

            for (char c : t.toCharArray()) {
                if (tempSticker.getOrDefault(c, 0) > 0) {
                    tempSticker.put(c, tempSticker.get(c) - 1);
                } else {
                    remainT.append(c);
                }
            }

            // Recursive DFS call for the remaining target
            if (remainT.length() != 0) {
                res = Math.min(res, 1 + dfs(remainT.toString()));
            } else {
                res = Math.min(res, 1);  // If no remaining characters, at least one sticker was used
            }
        }

        // Store the result in the memoization map
        dp.put(t, res);
        return res;
    }

}
