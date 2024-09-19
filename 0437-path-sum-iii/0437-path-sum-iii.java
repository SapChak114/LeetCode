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
        findSum(root, targetSum);
        return this.count;
    }

    void findSum(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }

        sums.add((long)root.val);

        findSum(root.left, targetSum);
        findSum(root.right, targetSum);

        long temp = 0;
        for (int i = sums.size()-1; i>=0; i--) {
            temp += sums.get(i);
            if (temp == targetSum) {
                count++;
            }
        }

        sums.remove(sums.size()-1);
    }
}