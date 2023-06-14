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
        preOrder(root);
        Collections.sort(list);
        
        int res = Integer.MAX_VALUE;
        for(int i = 1; i<list.size(); i++){
            res = Math.min(res,list.get(i)-list.get(i-1));
        }
        return res;
    }
    
    void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}