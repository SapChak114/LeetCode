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
    public List<TreeNode> generateTrees(int n) {
        return dfs(1,n);
    }
    
    List<TreeNode> dfs(int left, int right){
        if(left>right){
            return Collections.singletonList(null);
        }
        
        List<TreeNode> ans = new ArrayList<>();
        
        for(int mid = left; mid<=right; mid++){
            List<TreeNode> lTrees = dfs(left,mid-1);
            List<TreeNode> rTrees = dfs(mid+1,right);
            
            for(TreeNode l : lTrees){
                for(TreeNode r : rTrees){
                    ans.add(new TreeNode(mid,l,r));
                }
            }
        }
        
        return ans;
    }
}