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
    int targ;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        targ = targetSum;
        return dfs(root,0);
    }
    
    boolean dfs(TreeNode root, int currSum){
        if(root==null){
            return false;
        }
        
        if(root.left==null && root.right==null){
            return targ==currSum+root.val;
        }
        
        boolean left = dfs(root.left,currSum + root.val);
        boolean right = dfs(root.right,currSum + root.val);
        
        return left || right;
    }
}