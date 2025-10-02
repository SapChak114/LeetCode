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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return false;
        }
        q.add(root);
        int level = 0, dx = 0, dy = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i<size; i++) {
                TreeNode node = q.poll();

                if (node.left != null && node.right != null) {
                    if (node.left.val == x && node.right.val == y) {
                        return false;
                    }
                    if (node.left.val == y && node.right.val == x) {
                        return false;
                    }
                }

                if (node.val == x) {
                    dx = level;
                }
                if (node.val == y) {
                    dy = level;
                }

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }

            }
            level++;
        }

        return dx == dy;
    }
}