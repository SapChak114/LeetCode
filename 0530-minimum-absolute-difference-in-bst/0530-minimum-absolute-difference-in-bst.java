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
    TreeNode prevNode;
    int minDiff;
    public int getMinimumDifference(TreeNode root) {
        TreeNode prevNode=null;
        minDiff=Integer.MAX_VALUE;
        inOrder(root);
        return minDiff;
    }
    
    void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        if(prevNode!=null) minDiff = Math.min(minDiff,root.val-prevNode.val);
        prevNode = root;
        inOrder(root.right);
    }
}