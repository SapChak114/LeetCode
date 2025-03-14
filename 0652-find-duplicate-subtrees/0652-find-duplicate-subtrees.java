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
    List<TreeNode> ans;
    Map<String, Integer> counter;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        this.ans = new ArrayList<>();
        this.counter = new HashMap<>();

        dfs(root);
        return ans;
    }

    String dfs(TreeNode node) {
        if (node == null) {
            return "#";  // Use "#" to represent null nodes
        }

        // Serialize subtree uniquely
        String hash = "(" + dfs(node.left) + ")"
                    + node.val
                    + "(" + dfs(node.right) + ")";

        // Count occurrences of this subtree
        counter.put(hash, counter.getOrDefault(hash, 0) + 1);
        
        // If it's the second time we encounter this subtree, add it to the answer list
        if (counter.get(hash) == 2) {
            ans.add(node);
        }

        return hash;
    }
}