/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Map<Integer, Long> map = new HashMap<>();
        dfs(root, map, 0);

    
        List<Long> ans = new ArrayList<>(map.values());
        Collections.sort(ans, Collections.reverseOrder());
        if (ans.size() >= k) {
            return ans.get(k-1);
        } else {
            return -1;
        }
    }

    void dfs(TreeNode root, Map<Integer, Long> map, int level) {
        if (root == null) {
            return;
        }

        map.put(level, map.getOrDefault(level, 0L) + root.val);
        dfs(root.left, map, level + 1);
        dfs(root.right, map, level + 1);
    }
}