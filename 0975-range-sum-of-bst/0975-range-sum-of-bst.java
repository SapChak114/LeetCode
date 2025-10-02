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
    int low, high, sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        this.sum = 0;
        inorder(root);
        return this.sum;
    }

    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.val >= low && root.val <= high) {
            this.sum += root.val;
        }
        inorder(root.left);
        inorder(root.right);
    }
}