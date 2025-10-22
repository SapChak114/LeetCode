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
    int pre;
    Map<Integer, Integer> inMap;
    int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = 0;
        inMap = new HashMap<>();
        this.preorder = preorder;
        
        for (int i = 0; i<inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return build(0, inorder.length-1);
    }

    TreeNode build(int start, int end) {
        if (start > end) {
            return null;
        }

        int preorderNode = preorder[pre++];
        int inIndex = inMap.get(preorderNode);

        TreeNode root = new TreeNode(preorderNode);
        
        root.left = build(start, inIndex - 1);
        root.right = build(inIndex + 1, end);

        return root;
    }
}