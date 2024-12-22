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
    int height;
    public int diameterOfBinaryTree(TreeNode root) {
        this.height = 0;
        postOrder(root);
        return height;
    }

    int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = postOrder(root.left);
        int right = postOrder(root.right);

        height = Math.max(height, left + right);

        return 1 + Math.max(left, right);
    }
}