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
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        this.res = new ArrayList<>();
        dfs(root, "");
        return this.res;
    }

    void dfs(TreeNode root, String path) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            res.add(path+root.val);
            return;
        }

        path += root.val+"->";
        dfs(root.left, path);
        dfs(root.right, path);
    }
}