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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        searchBT(root, "", ans);
        return ans;
    }
    
    void searchBT(TreeNode root, String path, List<String> ans) {
        if (root.left == null && root.right == null) {
            path += root.val;
            ans.add(path);
        }

        if (root.left != null) {
            searchBT(root.left, path+root.val+"->", ans);
        }

        if (root.right != null) {
            searchBT(root.right, path+root.val+"->", ans);
        }
    }

}