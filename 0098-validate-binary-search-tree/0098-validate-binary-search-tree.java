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
    public boolean isValidBST(TreeNode root) {
        return check(root, null, null);
    }

    private boolean check(TreeNode root, Integer left, Integer right) {
        if (root == null) {
            return true;
        }

        int val = root.val;

        if (left != null && val <= left) {
            return false;
        }
        if (right != null && val >= right) {
            return false;
        }

        if (!check(root.right, val, right)) {
            return false;
        }

        if (!check(root.left, left, val)) {
            return false;
        }

        return true;
    }
}
