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
    int sum;
    public int sumEvenGrandparent(TreeNode root) {
        this.sum = 0;
        preorder(root, null, null);
        return this.sum;
    }

    void preorder(TreeNode root, TreeNode parent, TreeNode grandParent) {
        if (root == null) {
            return;
        }
        if (grandParent != null && grandParent.val % 2 == 0) {
            sum += root.val;
        }
        preorder(root.left, root, parent);
        preorder(root.right, root, parent);
    }
}