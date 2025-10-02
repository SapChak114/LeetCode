/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.ans = null;
        preorder(cloned, target);
        return this.ans;
    }

    void preorder(TreeNode cloned, TreeNode target) {
        if (cloned == null) {
            return;
        }

        if (cloned.val == target.val) {
            this.ans = cloned;
        }

        preorder(cloned.left, target);
        preorder(cloned.right, target);
    }
}