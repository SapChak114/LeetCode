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
    Map<Integer, Integer> preMap;
    Map<Integer, Integer> sufMap;
    int maxHeight;
    public int[] treeQueries(TreeNode root, int[] queries) {
        this.preMap = new HashMap<>();
        this.sufMap = new HashMap<>();
        this.maxHeight = 0;
        preSum(root, 0);
        this.maxHeight = 0;
        sufSum(root, 0);

        int[] res = new int[queries.length];
        int idx = 0;
        for (int q : queries) {
            res[idx++] = Math.max(preMap.get(q), sufMap.get(q));
        }

        return res;
    }

    void preSum(TreeNode root, int height) {
        if (root == null) {
            return;
        }

        preMap.put(root.val, maxHeight);
        maxHeight = Math.max(maxHeight, height);

        preSum(root.left, height + 1);
        preSum(root.right, height + 1);
    }

    void sufSum(TreeNode root, int height) {
        if (root == null) {
            return;
        }

        sufMap.put(root.val, maxHeight);
        maxHeight = Math.max(maxHeight, height);

        sufSum(root.right, height + 1);
        sufSum(root.left, height + 1);
    }
}