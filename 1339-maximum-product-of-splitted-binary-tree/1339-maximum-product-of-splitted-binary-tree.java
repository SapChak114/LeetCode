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
    long ans;
    long sum;
    long mod = (int)1e9 + 7;
    public int maxProduct(TreeNode root) {
        this.ans = 0;
        this.sum = dfs(root, false);
        dfs(root, true);

        return (int)(ans % mod);
    }

    long dfs(TreeNode root, boolean maxFind) {
        if (root == null) {
            return 0;
        }

        long val = root.val + dfs(root.left, maxFind) + dfs(root.right, maxFind);

        if (maxFind) {
            ans = Math.max(ans, val * (sum - val));
        }

        return val;
    }
}