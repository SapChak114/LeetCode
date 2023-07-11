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
        Map<TreeNode,TreeNode> parentTrack = new HashMap<>();
        markParent(root,parentTrack);
        
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode,Boolean> vis = new HashMap<>();
        int count = 0;
        q.add(target);
        vis.put(target,true);
        
        while(!q.isEmpty()){
            int size = q.size();
            if(count++ == k) break;
            
            for(int i = 0; i<size; i++){
                TreeNode current = q.poll();
                
                if(current.left!=null && vis.get(current.left)==null){
                    q.add(current.left);
                    vis.put(current.left,true);
                }
                if(current.right!=null && vis.get(current.right)==null){
                    q.add(current.right);
                    vis.put(current.right,true);
                }
                if(parentTrack.get(current)!=null && vis.get(parentTrack.get(current))==null){
                    q.add(parentTrack.get(current));
                    vis.put(parentTrack.get(current),true);
                }
            }
        }
        
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            res.add(q.poll().val);
        }
        
        return res;
    }
    
    void markParent(TreeNode root, Map<TreeNode,TreeNode> parentTrack){
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left!=null){
                parentTrack.put(node.left,node);
                q.add(node.left);
            }
            if(node.right!=null){
                parentTrack.put(node.right,node);
                q.add(node.right);
            }
        }
        
    }
    
}