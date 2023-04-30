class DSU{
    int[] parent;
    int[] size;
    int edges;
    
    public DSU(int n){
        this.parent = new int[n];
        this.size = new int[n];
        
        for(int i = 0; i<n; i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    
    int findParent(int a){
        if(parent[a]==a){
            return a;
        }
        
        return parent[a] = findParent(parent[a]);
    }
    
    int union(int a, int b){
        int pra = findParent(a);
        int prb = findParent(b);
        
        if(pra==prb){
            return 1;
        }
        
        if(size[pra]>=size[prb]){
            parent[prb] = pra;
            size[pra] += size[prb];
            edges++;
        } else{
            parent[pra] = prb;
            size[prb] += size[pra];
            edges++;
        }
        
        return 0;
    }
}
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU alice = new DSU(n+1);
        DSU bob = new DSU(n+1);
        
        int ans = 0;
        for(int i = 0; i<edges.length; i++){
            if(edges[i][0]==3){
                ans += alice.union(edges[i][1],edges[i][2]);
                bob.union(edges[i][1],edges[i][2]);
            }
        }
        
        for(int i = 0; i<edges.length; i++){
            if(edges[i][0]==1){
                ans += alice.union(edges[i][1],edges[i][2]);
            }
        }
        
        if(alice.edges!=n-1){
            return -1;
        }
        
        for(int i = 0; i<edges.length; i++){
            if(edges[i][0]==2){
                ans += bob.union(edges[i][1],edges[i][2]);
            }
        }
        
        if(bob.edges!=n-1){
            return -1;
        }
        
        return ans;
    }
}