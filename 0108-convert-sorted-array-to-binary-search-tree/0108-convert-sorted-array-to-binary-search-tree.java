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
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return bst(0, nums.length-1);
    }

    TreeNode bst(int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = l + (r-l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = bst(l, mid - 1);
        root.right = bst(mid + 1, r);

        return root;
    }
}