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
    Map<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    
    TreeNode build(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd){
        if(inStart>inEnd){
            return null;
        }
        int idx = map.get(pre[preStart]);
        int length = idx - inStart;
        
        TreeNode root = new TreeNode(in[idx]);
        
        root.left = build(pre,preStart+1,preStart+length,in,inStart,idx-1);
        root.right = build(pre,preStart+length+1,preEnd,in,idx+1,inEnd);
        
        return root;
    }
}