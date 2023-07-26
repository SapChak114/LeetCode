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
    List<Integer> res;
    public int countNodes(TreeNode root) {
        res = new ArrayList<>();
        preOrder(root);
        return res.size();
    }
    
    void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        
        res.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}