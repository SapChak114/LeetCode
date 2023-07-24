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
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postIndex = postorder.length-1;
        map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return build(postorder,inorder,0,inorder.length-1);
    }
    
    TreeNode build(int[] post, int[] in, int inStart, int inEnd){
        if(inStart>inEnd){
            return null;
        }
        int root_val = post[postIndex--];
        int idx = map.get(root_val);
        TreeNode root = new TreeNode(in[idx]);
        
        root.right = build(post,in,idx+1,inEnd);
        root.left = build(post,in,inStart,idx-1);
        
        return root;
    }
}