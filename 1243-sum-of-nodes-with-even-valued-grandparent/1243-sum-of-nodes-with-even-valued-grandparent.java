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
        preOrder(root, null, null);
        return this.sum;
    }

    void preOrder(TreeNode node, TreeNode parent, TreeNode grandParent) {
        if (node == null) {
            return;
        }

        if (grandParent != null && grandParent.val % 2 == 0) {
            this.sum += node.val;
        }

        preOrder(node.left, node, parent);
        preOrder(node.right, node, parent);
    }
}