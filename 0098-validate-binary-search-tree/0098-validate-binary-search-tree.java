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
//     public boolean isValidBST(TreeNode root) {
//         return val(root,null,null);
//     }
    
//     boolean val(TreeNode root,Integer min, Integer max){
//         if(root==null){
//             return true;
//         }
        
//         if((min!=null && root.val<=min) || (max!=null && root.val>=max)){
//             return false;
//         }
        
//         return val(root.left,min,root.val) || val(root.right,root.val,max);
//     }
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true; // Empty subtree is a valid BST.
        }
        
        // Check if the current node's value is within the specified range.
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }
        
        // For the left subtree, the maximum value should be the current node's value.
        // For the right subtree, the minimum value should be the current node's value.
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}