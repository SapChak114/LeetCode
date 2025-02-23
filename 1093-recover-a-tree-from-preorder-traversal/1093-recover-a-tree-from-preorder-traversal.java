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
    public TreeNode recoverFromPreorder(String trav) {
        int n = trav.length(), dashes = 0, i = 0;
        Stack<TreeNode> st = new Stack<>();

        while (i < n) {
            if (trav.charAt(i) == '-') {
                dashes++;
                i++;
            } else {
                int j = i;

                while (j < n && trav.charAt(j) != '-') {
                    j++;
                }

                int num = Integer.valueOf(trav.substring(i, j));

                while (!st.isEmpty() && st.size() > dashes) {
                    st.pop();
                }
                
                TreeNode node = new TreeNode(num);
                if (!st.isEmpty() && st.peek().left == null) {
                    st.peek().left = node;
                } else if (!st.isEmpty()) {
                    st.peek().right = node;
                }
                st.push(node);

                i = j;
                dashes = 0;
            }
        }
        
        while (st.size() != 1) {
            st.pop();
        }

        return st.peek();
    }
}