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
    public List<List<Integer>> levelOrder(TreeNode A) {
        if(A==null) return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        List<List<Integer>> list = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> al = new ArrayList<>();
            for(int i = 0; i<size; i++){
                TreeNode t = q.poll();
                al.add(t.val);
                if(t.left!=null) q.add(t.left);
                if(t.right!=null) q.add(t.right);
            }
            list.add(al);
        }

        return list;
    }
}