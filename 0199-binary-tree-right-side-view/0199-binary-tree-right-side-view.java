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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> li = new ArrayList<>();
            for(int i = 0; i<size; i++){
                TreeNode node = q.poll();
                li.add(node.val);
                
                if(node.left!=null){
                    q.add(node.left);
                }
                
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            ans.add(li.get(li.size()-1));
        }
        
        return ans;
    }
}