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
    List<Integer> list;
    public int kthSmallest(TreeNode root, int k) {
        this.list = new ArrayList<>();
        inorder(root);
        return list.get(k-1);
    }

    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}