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
    int preStart;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preStart=0;
        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return build(preorder,inorder,0,inorder.length-1);
    }
    
    TreeNode build(int[] pre, int[] in, int inStart, int inEnd){
        if(inStart>inEnd){
            return null;
        }
        int idx = map.get(pre[preStart++]);   
        TreeNode root = new TreeNode(in[idx]);
        
        root.left = build(pre,in,inStart,idx-1);
        root.right = build(pre,in,idx+1,inEnd);
        
        return root;
    }
}