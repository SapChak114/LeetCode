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
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> hm = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            hm.put(node.val, hm.getOrDefault(node.val, 0) + 1);

            if (node.left != null) {
                q.add(node.left);
            }

            if (node.right != null) {
                q.add(node.right);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int key : hm.keySet()) {
            max = Math.max(max, hm.get(key));
        }

        List<Integer> list = new ArrayList<>();
        for (int key : hm.keySet()) {
            if (hm.get(key) == max) {
                list.add(key);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i<res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}