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
class FindElements {
    HashSet<Integer> seen;
    public FindElements(TreeNode root) {
        seen = new HashSet<>();
        bfs(root);
    }
    
    public boolean find(int target) {
        return seen.contains(target);
    }

    private void bfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        root.val = 0;
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            
            seen.add(curr.val);
            if (curr.left != null) {
                curr.left.val = curr.val * 2 + 1;
                q.add(curr.left);
            }

            if (curr.right != null) {
                curr.right.val = curr.val * 2 + 2;
                q.add(curr.right);
            }
        }
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */