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
    List<Integer> list;
    public int getMinimumDifference(TreeNode root) {
        list = new ArrayList<>();
        inOrder(root);
        
        int res = Integer.MAX_VALUE;
        for(int i = 1; i<list.size(); i++){
            res = Math.min(res,list.get(i)-list.get(i-1));
        }
        return res;
    }
    
    void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}