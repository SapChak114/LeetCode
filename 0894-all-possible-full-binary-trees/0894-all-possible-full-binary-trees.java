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
    public List<TreeNode> allPossibleFBT(int n) {
        return helper(n);
        
    }
    
    List<TreeNode> helper(int n){
        if(n==1){
            List<TreeNode> li = new ArrayList<>();
            li.add(new TreeNode(0));
            return li;
        }
        
        List<TreeNode> node = new ArrayList<>();
        
        for(int i = 1; i<n; i+=2){
            List<TreeNode> first = helper(i);
            List<TreeNode> last = helper(n-i-1);
            
            for(TreeNode l : first){
                for(TreeNode r : last){
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    node.add(root);
                }
            }
        }
        
        return node;
    }
}