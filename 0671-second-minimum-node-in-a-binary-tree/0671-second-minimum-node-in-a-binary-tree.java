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
    int root;
    long smin;
    public int findSecondMinimumValue(TreeNode root) {
        this.root = root.val;
        this.smin = Long.MAX_VALUE;
        dfs(root);
        return (int) (this.smin == Long.MAX_VALUE ? -1 : this.smin);
    }

    void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        // root.val == min(root.left.val, root.right.val) for each internal node of the tree.
        if (node.val > root && node.val < smin) {
            smin = node.val;
        }

        dfs(node.left);
        dfs(node.right);
    }
}