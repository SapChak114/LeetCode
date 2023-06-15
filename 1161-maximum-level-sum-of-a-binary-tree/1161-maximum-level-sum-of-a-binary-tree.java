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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0, ans = 0;
        int maxSum = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            int sum = 0;
            for(int i = 0; i<size; i++){
                TreeNode node = q.poll();
                sum += node.val;
                
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            if(maxSum < sum){
                maxSum = sum;
                ans = level;               
            }
        }
        
        return ans;
    }
}