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
    int postIdx;
    Map<Integer, Integer> inMap;
    int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        postIdx = n-1;
        inMap = new HashMap<>();
        this.postorder = postorder;

        for (int i = 0; i<n; i++) {
            inMap.put(inorder[i], i);
        }

        return build(0, n-1);
    }

    TreeNode build(int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int postNode = postorder[postIdx];
        postIdx--;
        int inIdx = inMap.get(postNode);

        TreeNode root = new TreeNode(postNode);
        root.right = build(inIdx + 1, inEnd);
        root.left = build(inStart, inIdx - 1);

        return root;
    }
}