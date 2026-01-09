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
    Map<TreeNode, Integer> ndepth;
    int maxDepth;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        this.ndepth = new HashMap<>();
        this.maxDepth = -1;
        this.ndepth.put(null, -1);
        dfs(root, null);

        for (int val : ndepth.values()) {
            maxDepth = Math.max(maxDepth, val);
        }

        return ans(root);
    }

    void dfs(TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }

        ndepth.put(root, ndepth.get(parent) + 1);
        dfs(root.left, root);
        dfs(root.right, root);
    }

    TreeNode ans(TreeNode root) {
        if (root == null || ndepth.get(root) == maxDepth) {
            return root;
        }

        TreeNode left = ans(root.left);
        TreeNode right = ans(root.right);

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        if (right != null) {
            return right;
        }

        return null;
    }
}