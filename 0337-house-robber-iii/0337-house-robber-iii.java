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
    Map<TreeNode, Integer> map;
    public int rob(TreeNode root) {
        this.map = new HashMap<>();
        return dfs(root);
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (map.containsKey(root)) {
            return map.get(root);
        }

        int take = root.val;
        if (root.left != null) {
            take += dfs(root.left.left) + dfs(root.left.right);
        }
        if (root.right != null) {
            take += dfs(root.right.left) + dfs(root.right.right);
        }

        int dont = dfs(root.left) + dfs(root.right);

        int val = Math.max(take, dont);
        map.put(root, val);

        return val;
    }
}