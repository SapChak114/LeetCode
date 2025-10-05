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
    int k;
    Set<Integer> set;
    public boolean findTarget(TreeNode root, int k) {
        this.k = k;
        this.set = new HashSet<>();
        return dfs(root);
    }

    boolean dfs(TreeNode root) {
        if (root == null) {
            return false;
        }

        if (set.contains(k - root.val)) {
            return Boolean.TRUE;
        }
        set.add(root.val);

        return dfs(root.left) || dfs(root.right);
    }
}