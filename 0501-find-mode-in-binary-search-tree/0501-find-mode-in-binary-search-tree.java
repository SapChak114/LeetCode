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
            int size = q.size();
            for (int i = 0; i<size; i++) {
                TreeNode node = q.poll();
                hm.put(node.val, hm.getOrDefault(node.val, 0) + 1);

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }

        int maxFreq = 0;
        for (int key : hm.keySet()) {
            maxFreq = Math.max(maxFreq, hm.get(key));
        }

        List<Integer> res = new ArrayList<>();
        for (int key : hm.keySet()) {
            if (hm.get(key) == maxFreq) {
                res.add(key);
            }
        }

        int[] result = new int[res.size()];
        for (int i = 0; i<result.length; i++) {
            result[i] = res.get(i);
        }

        return result;
    }
}