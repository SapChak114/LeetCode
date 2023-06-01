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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> inorderList = new ArrayList<>();
        List<Integer> postorderList = new ArrayList<>();

        for (int num : inorder) {
            inorderList.add(num);
        }

        for (int num : postorder) {
            postorderList.add(num);
        }

        return buildTreeHelper(inorderList, postorderList);
    }

    TreeNode buildTreeHelper(List<Integer> inorder, List<Integer> postorder) {
        int n = inorder.size();
        int m = postorder.size();
        if (n == 0 || m == 0)
            return null;

        TreeNode root = new TreeNode(postorder.get(m - 1));
        int mid = inorder.indexOf(root.val);

        root.left = buildTreeHelper(inorder.subList(0, mid), postorder.subList(0, mid));
        root.right = buildTreeHelper(inorder.subList(mid + 1, n), postorder.subList(mid, m - 1));

        return root;
    }

}
