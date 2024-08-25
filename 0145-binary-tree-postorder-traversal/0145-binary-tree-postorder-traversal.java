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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        Stack<Boolean> vis = new Stack<>();

        st.push(root);
        vis.push(false);

        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            Boolean v = vis.pop();

            if (curr != null) {
                if (v) {
                    ans.add(curr.val);
                } else {
                    st.push(curr);
                    vis.push(true);
                    
                    if (curr.right != null) {
                        st.push(curr.right);
                        vis.push(false);
                    }
                    if (curr.left != null) {
                        st.push(curr.left);
                        vis.push(false);
                    }
                }
            }
        }

        return ans;
    }
}
/*
            1
                    2
                3
*/