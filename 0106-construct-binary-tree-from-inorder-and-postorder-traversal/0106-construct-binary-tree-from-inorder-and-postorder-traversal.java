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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return build(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }
    
    TreeNode build(int[] post,int postStart, int postEnd, int[] in, int inStart, int inEnd){
        if(inStart>inEnd || (postStart>postEnd)){
            return null;
        }
        int root_val = post[postEnd];
        int idx = map.get(root_val);
        int length = idx - inStart;
        TreeNode root = new TreeNode(in[idx]);
        
        root.left = build(post,postStart,postStart+length-1,in,inStart,idx-1);
        root.right = build(post,postStart+length,postEnd-1,in,idx+1,inEnd);
        
        return root;
    }
}