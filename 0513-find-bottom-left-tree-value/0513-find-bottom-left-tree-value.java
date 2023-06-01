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
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        
        TreeNode node = null;
        q.add(root);
        while(!q.isEmpty()){
            node = q.removeFirst();
            
            if(node.right !=null) q.add(node.right);
            if(node.left !=null) q.add(node.left);
        }
        
        return node.val;
    }
}