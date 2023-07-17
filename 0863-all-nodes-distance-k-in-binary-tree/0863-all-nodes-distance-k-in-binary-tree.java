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
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        findParent(parent,root,null);    
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        int count = 0;
        Map<TreeNode,Boolean> vis = new HashMap<>();
        vis.put(target,true);
        while(!q.isEmpty()){
            int size = q.size();
            if(count++ == k) break;
            
            for(int i = 0; i<size; i++){
                TreeNode n = q.poll();
                if(n.left!=null && vis.get(n.left)==null){
                    vis.put(n.left,true);
                    q.add(n.left);
                }
                if(n.right!=null && vis.get(n.right)==null){
                    vis.put(n.right,true);
                    q.add(n.right);
                }
                if(parent.get(n)!=null && vis.get(parent.get(n))==null){
                    vis.put(parent.get(n),true);
                    q.add(parent.get(n));
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        while(!q.isEmpty()){
            list.add(q.poll().val);
        }
        
        return list;
    }
    
    void findParent(Map<TreeNode,TreeNode> fp, TreeNode node, TreeNode parent){
        if(node!=null){
            fp.put(node,parent);
            findParent(fp,node.left,node);
            findParent(fp,node.right,node);
        }
    }
}