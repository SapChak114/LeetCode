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
    int preIdx, postIdx;
    int[] pre, post;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        this.preIdx = 0;
        this.postIdx = 0;
        this.pre = pre;
        this.post = post;

        return build();
    }

    TreeNode build() {
        TreeNode node = new TreeNode(pre[preIdx++]);

        if (node.val != post[postIdx]) {
            node.left = build();
        }

        if (node.val != post[postIdx]) {
            node.right = build();
        }

        postIdx++;
        return node;
    }
}