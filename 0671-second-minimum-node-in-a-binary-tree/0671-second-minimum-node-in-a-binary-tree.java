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
    long min, smin;
    public int findSecondMinimumValue(TreeNode root) {
        this.min = root.val;
        this.smin = Long.MAX_VALUE;
        preorder(root);
        return this.smin == Long.MAX_VALUE ? -1 : (int)this.smin;
    }

    void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.val > min && root.val < smin) {
            smin = root.val;
        }
        preorder(root.left);
        preorder(root.right);
    }
}