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
    public boolean checkTree(TreeNode root) {
        return preorder(root);
    }

    boolean preorder(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.right != null && root.val != root.left.val + root.right.val) {
            return false;
        }

        boolean left = preorder(root.left);
        boolean right = preorder(root.right);

        return left && right;
    }
}