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
    List<TreeNode> ans;
    Set<Integer> nodes;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        this.ans = new ArrayList<>();
        this.nodes = Arrays.stream(to_delete).boxed().collect(Collectors.toSet());
        TreeNode resp = dfs(root);

        if (resp != null) {
            ans.add(resp);
        }

        return ans;
    }

    TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = dfs(root.left);
        root.right = dfs(root.right);

        if (nodes.contains(root.val)) {
            if (root.left != null) {
                ans.add(root.left);
            }
            if (root.right != null) {
                ans.add(root.right);
            }
            return null;
        }


        return root;      
    }
}