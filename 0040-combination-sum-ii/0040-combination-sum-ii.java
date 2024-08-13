public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // Sort the input array
        List<List<Integer>> result = new ArrayList<>();
        
        dfs(candidates, target, 0, new ArrayList<>(), result);
        
        return result;
    }

    private void dfs(int[] candidates, int target, int idx, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path)); // Found a valid combination
            return;
        }
        
        if (target < 0 || idx >= candidates.length) {
            return; // If target becomes negative or idx is out of bounds, return
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue; // Skip duplicates
            }
            
            path.add(candidates[i]); // Choose the current element
            dfs(candidates, target - candidates[i], i + 1, path, result); // Recurse with remaining target
            path.remove(path.size() - 1); // Backtrack
        }
    }
}