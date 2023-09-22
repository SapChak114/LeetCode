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
    int postIndex;
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postIndex = postorder.length-1;
        map = new HashMap<>();
        
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        
        return build(0,inorder.length-1,inorder,postorder);
    }
    
    TreeNode build(int inStart, int inEnd, int[] in, int[] post){
        if(inStart>inEnd){
            return null;
        }
        
        int r = post[postIndex--];
        int idx = map.get(r);
        
        TreeNode root = new TreeNode(in[idx]);
        
        root.right = build(idx+1,inEnd,in,post);
        root.left = build(inStart,idx-1,in,post);
        
        return root;
    }
}