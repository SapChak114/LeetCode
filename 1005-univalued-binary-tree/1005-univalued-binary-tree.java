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
    int val;
    boolean isUni;
    public boolean isUnivalTree(TreeNode root) {
        this.val = root.val;
        this.isUni = true;
        preorder(root);
        return this.isUni;
    }

    void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.val != val) {
            isUni = false;
        }
        preorder(root.left);
        preorder(root.right);
    }
}