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
    Map<Integer, Integer> map;
    public int[] findMode(TreeNode root) {
        this.map = new HashMap<>();
        inorder(root);

        int maxFreq = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            maxFreq = Math.max(maxFreq, e.getValue());
        }
        
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == maxFreq) {
                ans.add(e.getKey());
            }
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i<ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        map.put(root.val, map.getOrDefault(root.val, 0)+1);
        inorder(root.right);
    }
}