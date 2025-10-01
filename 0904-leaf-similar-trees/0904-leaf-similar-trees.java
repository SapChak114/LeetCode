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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> fl = new ArrayList<>();
        populateLeaves(root1, fl);
        List<Integer> sl = new ArrayList<>();
        populateLeaves(root2, sl);

        return fl.equals(sl);
    }

    void populateLeaves(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                list.add(root.val);
                return;
            }
            populateLeaves(root.left, list);
            populateLeaves(root.right, list);
        }
    }
}