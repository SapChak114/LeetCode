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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        List<Integer> listSum = new ArrayList<>();

        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            int levelSum = 0;

            for (int i = 0; i<size; i++) {
                TreeNode node = nodeQueue.poll();
                levelSum += node.val;

                if (node.left != null) {
                    nodeQueue.add(node.left);
                }
                if (node.right != null) {
                    nodeQueue.add(node.right);
                }
            }
            listSum.add(levelSum);
        }

        nodeQueue.add(root);
        root.val = 0;
        int level = 1;

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            for (int i = 0; i<size; i++) {
                TreeNode node = nodeQueue.poll();
                int siblingsSum = (node.left != null ? node.left.val : 0) + (node.right != null ? node.right.val : 0);

                if (node.left != null) {
                    node.left.val = listSum.get(level) - siblingsSum;
                    nodeQueue.add(node.left);
                }

                if (node.right != null) {
                    node.right.val = listSum.get(level) - siblingsSum;
                    nodeQueue.add(node.right);
                }
            }
            level++;
        }

        return root;
    }
}