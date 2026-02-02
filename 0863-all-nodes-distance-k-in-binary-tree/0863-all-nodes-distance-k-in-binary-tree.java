/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentT = new HashMap<>();
        makeP(root, parentT);
        Map<TreeNode, Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        vis.put(target, true);
        int cur = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            if (cur == k) {
                break;
            }
            cur++;
            for (int i = 0; i<size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null && !vis.containsKey(curr.left)) {
                    q.add(curr.left);
                    vis.put(curr.left, true);
                }
                if (curr.right != null && !vis.containsKey(curr.right)) {
                    q.add(curr.right);
                    vis.put(curr.right, true);
                }
                if (parentT.containsKey(curr) && !vis.containsKey(parentT.get(curr))) {
                    q.add(parentT.get(curr));
                    vis.put(parentT.get(curr), true);
                }
            }
        }

        List<Integer> res = new ArrayList<>();

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            res.add(curr.val);
        }

        return res;
    }

    private void makeP(TreeNode root, Map<TreeNode, TreeNode> parentT) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                parentT.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                parentT.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }
}