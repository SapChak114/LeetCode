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
    private int currentVal;
    private int currentCount;
    private int maxFrequency;
    private int modeCount;
    private int[] modes;

    public int[] findMode(TreeNode root) {
        if ((root.left == null && root.right ==null)) {
            return new int[]{root.val};
        }
        // First pass: Find the maximum frequency
        inorder(root, false);

        // Allocate space for the modes
        modes = new int[modeCount];
        modeCount = 0;
        currentVal = Integer.MIN_VALUE; // Reset to an initial state
        currentCount = 0;

        // Second pass: Collect the modes
        inorder(root, true);

        return modes;
    }

    private void inorder(TreeNode node, boolean collectModes) {
        if (node == null) {
            return;
        }

        // In-order traversal: Left -> Node -> Right
        inorder(node.left, collectModes);

        // Process current node
        if (currentVal != node.val) {
            currentVal = node.val;
            currentCount = 0;
        }
        currentCount++;

        if (currentCount > maxFrequency) {
            maxFrequency = currentCount;
            // if (!collectModes) {
                modeCount = 1; // Reset mode count in first pass
            // }
        } else if (currentCount == maxFrequency) {
            if (collectModes) {
                modes[modeCount] = currentVal;
            }
            modeCount++;
        }

        inorder(node.right, collectModes);
    }
}
