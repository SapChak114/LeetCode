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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inorder(root, nodes);
        return createBst(root, nodes, 0, nodes.size()-1);
    }

    void inorder(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }

        inorder(root.left, nodes);
        nodes.add(root.val);
        inorder(root.right, nodes);
    }

    TreeNode createBst(TreeNode root, List<Integer> nodes, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) >> 1;
        TreeNode left = createBst(root, nodes, start, mid - 1);
        TreeNode right = createBst(root, nodes, mid + 1, end);

        return new TreeNode(nodes.get(mid), left, right);

    }
}