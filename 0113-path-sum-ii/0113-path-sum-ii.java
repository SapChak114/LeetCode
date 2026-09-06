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
    public List<List<Integer>> pathSum(TreeNode root, int targ) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targ, path, ans);
        return ans;
    }

    void dfs(TreeNode root, int rem, List<Integer> path, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }

        path.add(root.val);

        rem -= root.val;

        boolean isLeaf = root.left == null && root.right == null;

        if (isLeaf && rem == 0) {
            ans.add(new ArrayList<>(path));
        }

        dfs(root.left, rem, path, ans);
        dfs(root.right, rem, path, ans);

        path.remove(path.size()-1);
    }
}