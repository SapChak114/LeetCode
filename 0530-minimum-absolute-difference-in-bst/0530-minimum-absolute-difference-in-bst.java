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
    int min;
    TreeNode prev;
    public int getMinimumDifference(TreeNode root) {
        this.min = Integer.MAX_VALUE;
        dfs(root);
        return this.min;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        if (prev != null) {
            min = Math.min(min, Math.abs(root.val - prev.val));
        }
        prev = root;
        dfs(root.right);
    }
}