/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return cons(grid,0,0,grid.length);
    }
    
    Node cons(int[][] grid, int x, int y, int l){
        Node ans = new Node();
        if(l==1){
            ans.isLeaf = true;
            if(grid[x][y]!=0){
                ans.val = true;
            } else{
                ans.val = false;
            }
            
            return ans;
        }
        
        Node tl = cons(grid,x,y,l/2);
        Node tr = cons(grid,x,y+(l/2),l/2);
        Node bl = cons(grid,x+l/2,y,l/2);
        Node br = cons(grid,x+l/2,y+l/2,l/2);
        
        if(tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf &&
           tl.val==tr.val && bl.val==br.val && tl.val==bl.val){
            ans.isLeaf = true;
            ans.val = tl.val;
        } else{
            ans.topLeft = tl;
            ans.topRight = tr;
            ans.bottomLeft = bl;
            ans.bottomRight = br;
        }
        
        return ans;
    }
}