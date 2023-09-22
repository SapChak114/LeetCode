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
    int preStart;
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preStart = 0;
        map = new HashMap<>();
        
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        
        return build(0,inorder.length-1,preorder,inorder);
    }
    
    TreeNode build(int inStart, int inEnd, int[] preorder, int[] inorder){
        if(inStart>inEnd){
            return null;
        }
        
        int idx = map.get(preorder[preStart++]);
        TreeNode root = new TreeNode(inorder[idx]);
        
        root.left = build(inStart,idx-1,preorder,inorder);
        root.right = build(idx+1,inEnd,preorder,inorder);
        
        return root;
    }
}