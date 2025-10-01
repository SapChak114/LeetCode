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
    List<String> list;
    public List<String> binaryTreePaths(TreeNode root) {
        this.list = new ArrayList<>();
        dfs(root, "");
        return list;
    }

    void dfs(TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            list.add(path+root.val);
            return;
        }

        if (root.left != null) {
            dfs(root.left, path+root.val+"->");
        }

        if (root.right != null) {
            dfs(root.right, path+root.val+"->");
        }
    }
}