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
        int maxFreq = 0, maxElem = 0;

        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > maxFreq) {
                maxFreq = e.getValue();
                maxElem = e.getKey();
            }
        }
        
        ans.add(maxElem);
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == maxFreq && e.getKey() != maxElem) {
                ans.add(e.getKey());
            }
        }
        int[] res = new int[ans.size()];

        for (int i = 0; i<res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        inorder(root.right);
    }
}