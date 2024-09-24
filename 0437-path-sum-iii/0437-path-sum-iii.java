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
    int count;
    List<Long> sums;
    public int pathSum(TreeNode root, int targetSum) {
        this.count = 0;
        this.sums = new ArrayList<>();
        rec(root, targetSum);
        return this.count;
    }

    void rec(TreeNode root, int targ) {
        if (root == null) {
            return;
        }

        sums.add((long)root.val);

        rec(root.left, targ);
        rec(root.right, targ);

        long sum = 0;
        for (int i = sums.size()-1; i>=0; i--) {
            sum += sums.get(i);
            if (sum == targ) {
                count++;
            }
        }

        sums.remove(sums.size()-1);
    }
}