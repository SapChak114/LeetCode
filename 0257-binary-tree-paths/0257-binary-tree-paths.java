class Solution {
    Set<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        this.ans = new HashSet<>();
        dfs(root, "");
        return new ArrayList<>(ans);
    }

    void dfs(TreeNode root, String s) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            ans.add((s+root.val));
            return;
        }

        s += root.val + "->";

        dfs(root.left, s);
        dfs(root.right, s);
    }
}