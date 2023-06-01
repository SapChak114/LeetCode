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
    public TreeNode buildTree(int[] A, int[] B) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i<B.length; i++){
            map.put(B[i],i);
        }

        return build(A,0,B.length-1,B,0,B.length-1,map);
    }
    
    TreeNode build(int[] A, int preStart, int preEnd, int[] B, int inStart, int inEnd, Map<Integer,Integer> map){
        if(inStart>inEnd) return null;

        TreeNode root = new TreeNode(A[preStart]);
        int index = map.get(root.val);
        int length = index - inStart;

        root.left = build(A,preStart+1,preStart+length,B,inStart,index-1,map);
        root.right = build(A,preStart+length+1,preEnd,B,index+1,inEnd,map);

        return root;
    }
}